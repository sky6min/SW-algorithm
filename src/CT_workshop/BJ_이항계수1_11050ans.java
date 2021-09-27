package CT_workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_이항계수1_11050ans {

    static int N, K;
    static int[][] bc;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bc = new int[N+1][K+1];
        bc[0][0] = 1;

        for (int n = 1; n <= N; n++) {
            // nCo == nCn == 1
            bc[n][0] = 1;

            for(int k=1; k<=K; k++) {
                bc[n][k] = bc[n-1][k-1] + bc[n-1][k];
            }
        }

        System.out.println(bc[N][K]);
    }

}
