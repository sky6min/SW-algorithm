package test1;

import java.util.Arrays;

public class test_DP1_ans {

    static int dp[] = new int[11];  // 0 dummy
    public static void main(String[] args) {
        dp[1] = 2;
        dp[2] = 3;

        for(int i=3; i<=10; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(Arrays.toString(dp));
    }
}
