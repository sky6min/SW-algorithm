package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_설탕배달_2839 {

    static int dp[] = new int[5001];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Arrays.fill(dp,5000);

        int N = Integer.parseInt(br.readLine());

        dp[3] = 1;
        dp[5] = 1;
        for(int i=6; i<=N;i++) {

            dp[i] = Math.min(dp[i-5] + 1,dp[i-3] + 1);

        }
        if(dp[N] >= 5000) System.out.println("-1");
        else System.out.println(dp[N]);
    }
}