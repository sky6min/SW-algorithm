package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_MAKE1_1463 {

    static int dp[] = new int [1000001];
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        int res = recur(N);
        System.out.println(res);
    }

    static int recur(int N) {

        for(int i=2; i<=N; i++) {

            dp[i] = dp[i-1] + 1;

            if( i % 3 == 0 ) {
                dp[i] = Math.min(dp[i] ,dp[i/3]+1);

            }
            if( i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }

        }
        return dp[N];
    }
}
