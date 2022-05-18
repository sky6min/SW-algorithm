package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_수묶기_1744 {

    public static void main(String[] args) throws Exception {
        int ary[] = new int[2001];
        boolean visited[] = new boolean[2001];
        for(int i=0; i<2001; i++) {
            ary[i] = -1000 + i;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int val = Integer.parseInt(br.readLine());
            for (int j = 0; j < 2001; j++) {
                if (ary[j] == val) {
                    visited[j] = true;
                }
            }
        }

        int minusNum = 0;
        int flag = 0;
        int flag2 = 0;
        // 음수의 갯수 세기.
        for(int i = 0; i < 2001; i++) {
            if(i<1000 && visited[i]) {
                minusNum++;
            }
        }
        // 0이 존재함.
        if(visited[1000]) {
            flag = 1;
        }
        if(visited[1001]) {
            flag2 = 1;
        }

        int cnt = 0;
        int res = 0;
        int num[] = new int[2];
        for(int i=0; i<1000; i++) {
            if(visited[i]) {
                if(cnt == 2) {
                    cnt = 0;
                    res += (num[0] * num[1]);
                }else {
                    num[cnt++] = ary[i];
                    if(cnt == 2 && i == 999) {
                        cnt = 0;
                        res += (num[0] * num[1]);
                    }
                }
            }

        }
        // 음수 개수가 홀수이면서 0이 존재하지 않으면
        if(minusNum % 2 != 0 && flag == 0) {
            res += num[0];
        }

        cnt = 0;
        for(int i=2000; i>1000; i--) {
            if(visited[i]) {
                if(cnt == 2) {
                    cnt = 0;
                    res += (num[0] * num[1]);
                    System.out.println(res);
                    System.out.println(num[0]+ "," + num[1]);
                }else {
                    num[cnt++] = ary[i];

                    if(cnt == 2 && i == 1001) {
                        cnt = 0;
                        res += (num[0] * num[1]);
                    }
                }
            }
        }
        // 1이 존재하고, cnt == 1 이면
        if(flag2 == 1 && cnt == 1) {
            res += (num[0] + 1);
        }

        if(flag2 == 0 && cnt == 1) {
            res += (num[0]);
        }
        if(flag2 == 1 && cnt == 0) {
            res += 1;
        }

        System.out.println(res);
    }
}
