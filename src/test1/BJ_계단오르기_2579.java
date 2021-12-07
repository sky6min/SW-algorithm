package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_계단오르기_2579 {

    static int dp[][];
    static int val[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        val = new int[N+1];
        dp = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            val[i] = Integer.parseInt(br.readLine());
        }
        dp[1][0] = val[1];
        dp[1][1] = val[1];
        System.out.println(Math.max(find(N, 0),find(N, 1)));

    }

    static public int find(int n, int type) {
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return val[1];
        }
        if(dp[n][type] != 0) {
            return dp[n][type];
        }
        // 다음 턴은 2칸 내려가고 1번타입으로 변환
        if(type == 0) {
            dp[n-2][1] = find(n-2,1);
            return find(n-2, 1) + val[n];
        } // 다음턴은 2칸이나 1칸 내려가고 각 타입으로 변환
        else {
            dp[n-2][1] = find(n-2, 1);
            dp[n-1][0] = find(n-1, 0);
            return Math.max( find(n-2,1)+val[n], find(n-1, 0) + val[n]);
        }

    }
}
