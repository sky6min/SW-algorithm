package test1;

public class Test_DP1 {

    public static void main(String[] args) {
        int dp[] = new int [100];

        dp[0] = 1;
        dp[1] = 2;

        for(int i=2; i<=8; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[8]);
    }
}
