package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_신고결과받기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        sol.solution(id_list, report, 2);
    }

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            HashMap<String, ArrayList<String>> dic = new HashMap<String, ArrayList<String>>();
            HashMap<String, Integer> cnt = new HashMap<String, Integer>();

            for (int i = 0; i < id_list.length; i++) {
                ArrayList<String> list = new ArrayList<String>();
                dic.put(id_list[i],list);
            }

            // 각 유저가 신고한 사람
            for (int i = 0; i < report.length; i++) {
                StringTokenizer st = new StringTokenizer(report[i]);
                String reporter = st.nextToken();
                String banner = st.nextToken();
                ArrayList<String> list = new ArrayList<String>();
                if (dic.containsKey(reporter)) {
                    int flag = 0;
                    list = dic.get(reporter);
                    for(int j=0; j< list.size(); j++) {
                        String m = list.get(j);
                        if(m.equals(banner)) {
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 0) {
                        list.add(banner);
                    }
                } else {
                    list.add(banner);
                }

                dic.put(reporter, list);
            }

            // 신고당한 횟수
            for (int i = 0; i < id_list.length; i++) {
                ArrayList<String> list = new ArrayList<String>();
                list = dic.get(id_list[i]);

                for (int j = 0; j < list.size(); j++) {
                    String banner = list.get(j);
                    if (cnt.containsKey(banner)) {
                        int count = cnt.get(banner);
                        count = count + 1;
                        cnt.put(banner, count);
                    } else {
                        int count = 1;
                        cnt.put(banner, count);
                    }
                }


            }

            // 메일 전달
            for (int i = 0; i < id_list.length; i++) {
                int c = 0;
                ArrayList<String> list = new ArrayList<String>();
                list = dic.get(id_list[i]); // id_list에 있는 문자열로 dic에서 ArrayList get

                for (int j = 0; j < list.size(); j++) {
                    String target = list.get(j);
                    int count = cnt.get(target);
                    if (count >= k) {
                        c++;
                    }
                }
                answer[i] = c;
            }

            return answer;
        }
    }

}