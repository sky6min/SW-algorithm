package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_계단오르기_2579 {

    static int dp[];
    static int val[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        val = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            val[i] = Integer.parseInt(br.readLine());
        }

        int n = 2;
        dp[0] = 0;
        dp[1] =
    }
}
