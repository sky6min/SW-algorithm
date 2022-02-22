package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

public class Bj_홀수홀릭호석_20164 {

    static int[] src;

    static int[] tgt;


    static int max= Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();         // String 계산해야하는 값
        int val = Integer.parseInt(value); // int 계산해야하는 값
        src = new int[value.length()];
        tgt = new int[value.length()];
        int temp = val;
        int res = 0;
        for (int i = 0; i < value.length(); i++) {
            int odd = temp % 10;
            if(odd % 2 == 1) {
                res++;
            }
            temp = temp / 10;

        }
        dfs(value,val,res,1,0);   // 현재값, 현재 srcIdx, 현재 tgtIdx
        System.out.println(min + " " + max);
    }

    static void dfs(String value ,int val ,int res ,int srcIdx , int tgtIdx) {
        if(tgtIdx == 2) {
            if(value.length() >= 3) {
            int size = value.toCharArray().length;
            // 잘라야하는 위치 2개가 정해진 상태
            String part1 = value.substring(tgt[1],size);
            String part2 = value.substring(tgt[0],tgt[1]);
            String part3 = value.substring(0,tgt[0]);
            // 각 부분을 더한값이 100보다 크다면? dfs 순환함
            int ipart1 = Integer.parseInt(part1);
            int ipart2 = Integer.parseInt(part2);
            int ipart3 = Integer.parseInt(part3);
            val = ipart1 + ipart2 + ipart3;
            value = Integer.toString(val);
            int temp2 = val;
            for (int i = 0; i < value.length(); i++) {
                int odd = temp2 % 10;
                if(odd % 2 == 1) {
                    res++;
                }
                temp2 = temp2 / 10;
            }
            dfs(value,val,res,srcIdx, tgtIdx);
            return;
            }
            else if(value.length() == 2){
                val = value.charAt(0) - '0' + value.charAt(1) - '0';
                value = Integer.toString(val);
                int temp3 = val;
                for (int i = 0; i < value.length(); i++) {
                    int odd = temp3 % 10;
                    if(odd % 2 == 1) {
                        res++;
                    }
                    temp3 = temp3 / 10;
                }
                dfs(value,val,res,srcIdx, tgtIdx);
                return;
            }
            if(val % 2 == 1) {
                res++;
            }

            max = Math.max(max,res);
            min = Math.min(min,res);
            // 100보다 작으면 개수 세고 2 1, 1 0으로 나눔
            // 더한다음에 개수 셈   10보다 크면? 다시 나줌 10보다 크면?
            return;
            //
        }

        if(srcIdx == value.length()) {
            return;
        }

        tgt[tgtIdx] = srcIdx;

        dfs(value,val,res,srcIdx+1, tgtIdx+1);

        dfs(value,val,res,srcIdx+1, tgtIdx);


    }
}
