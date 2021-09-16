package test1;

public class Test_DP2 {

    public static void main(String[] args) {
        int dp[] = new int[100];

        dp[1] = 2;
        dp[2] = 5;

        for(int i=3; i<=6; i++) {
            dp[i] = dp[i-1] * dp[i-2];
        }

        System.out.println(dp[6]);
    }
}
