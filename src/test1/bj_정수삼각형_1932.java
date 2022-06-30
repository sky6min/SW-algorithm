package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_정수삼각형_1932 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int map[][] = new int[N][N];
        int dp[][] = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; st.hasMoreTokens(); j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = dp[i][j] = val;
            }

        }

        for(int i=N-2; i>=0; i--) {

            for(int j=0; j<N-1; j++) {
                dp[i][j] = Math.max(dp[i+1][j] + map[i][j], dp[i+1][j+1] + map[i][j]);

            }
        }

        System.out.println(dp[0][0]);
    }
}
