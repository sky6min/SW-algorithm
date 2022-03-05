package test1;

import java.text.SimpleDateFormat;
import java.util.*;

public class PG_오픈채팅방_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] example = {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
        sol.solution(example);
    }

    static class Solution {
        public int[] solution(String[] purchase) {
            int[] answer = new int[5];
            boolean[][] date = new boolean[13][32]; // 1~12월 1일 ~ 31일

            // 날짜 세팅
            for (int i = 1; i < 32; i++) {
                date[1][i] = true;
                date[3][i] = true;
                date[5][i] = true;
                date[7][i] = true;
                date[8][i] = true;
                date[10][i] = true;
                date[12][i] = true;
            }
            for (int i = 1; i < 29; i++) {
                date[2][i] = true;
            }

            for (int i = 1; i < 31; i++) {
                date[4][i] = true;
                date[6][i] = true;
                date[9][i] = true;
                date[11][i] = true;
            }

            // 최근 30일 간 구매 금액 계산
            for (int i = 1; i < 13; i++) {   // i = 월
                for (int j = 1; j < 32; j++) {   // j = 일
                    if (!date[i][j]) break;
                    int price = 0;
                    // purchase 비교해서 범위 안 다 더하기
                    for (int k = 0; k < purchase.length; k++) {
                        StringTokenizer st = new StringTokenizer(purchase[k]);
                        String day = st.nextToken();
                        int p = Integer.parseInt(st.nextToken());

                        // 현재 날짜
                        String curdate = "2019/";
                        if (i < 10) {
                            curdate = curdate + "0" + i + "/";
                        } else {
                            curdate = curdate + i + "/";
                        }

                        if (j < 10) {
                            curdate = curdate + "0" + j;
                        } else {
                            curdate = curdate + j;
                        }
                        try {
                            System.out.println(curdate);
                            Date cdate = new SimpleDateFormat("yyyy/MM/dd").parse(curdate);
                            Calendar cmpDate = Calendar.getInstance();
                            cmpDate.setTime(cdate); //현재 일자

                            // 비교 날짜
                            System.out.println(day);
                            Date ddate = new SimpleDateFormat("yyyy/MM/dd").parse(day);
                            Calendar dmpDate = Calendar.getInstance();
                            dmpDate.setTime(ddate); //비교 일자
                            if(cmpDate.getTimeInMillis() < dmpDate.getTimeInMillis()) continue;
                            long diffSec = Math.abs((dmpDate.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000);
                            long diffDays = diffSec / (24 * 60 * 60); //일자수 차이
                            System.out.println(diffDays);
                            if (diffDays <= 30) {
                                price = price + p;
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }

                    if (price >= 0 && price < 10000) {
                        answer[0]++;
                    } else if (price >= 10000 && price < 20000) {
                        answer[1]++;
                    } else if (price >= 20000 && price < 50000) {
                        answer[2]++;
                    } else if (price >= 50000 && price < 100000) {
                        answer[3]++;
                    } else if (price >= 100000) {
                        answer[4]++;
                    }
                }

            }

            // 해당 금액에 따른 브론즈 ~ 다이아몬드 일수 계산


            return answer;
        }
    }
}
