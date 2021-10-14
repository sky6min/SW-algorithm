package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_계단수_10844 {

    static int N;
    static Long dp[][];
    final static long MOD = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Long[N+1][10];

        for(int i=0; i<10; i++) {
            dp[1][i] = 1L;
        }

        long res = 0;
        for(int i=1; i<10; i++) {
            res += recur(N,i);

        }
        System.out.println(res % MOD);
    }

    static long recur(int N, int val) {
        if(N == 1) {
            return dp[N][val];
        }
        if(dp[N][val] != null) {
            return dp[N][val] % MOD;
        }

        if(val == 0) {
            return dp[N][val] = recur(N-1, 1) % MOD;
        }else if(val == 9) {
            return dp[N][val] = recur(N-1, 8) % MOD;
        }

        return dp[N][val] = recur(N-1, val-1)  % MOD + recur(N-1, val+1)  % MOD;

    }
}
