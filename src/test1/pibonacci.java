package test1;

public class pibonacci {

    static int N;
    static int dp[] = new int[100];
    public static void main(String[] args) {
        dp[0] = 1;
        dp[1] = 1;
        int sum = 0;
        N = 25;
        sum = recur(7);
        System.out.println(sum);
    }

    static int recur(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = recur(n-2) + recur(n-1);
    }
}
