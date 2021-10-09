package CT_workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_성수의공격_6026 {

    static int T, M, N;
    static int[][] bc;
    static int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        bc = new int[101][101];
        bc[0][0]  = 1;

        for(int n = 1; n<=100; n++ ) {
            //nCo
            bc[n][0] = 1;

            for(int k = 1; k<=100; k++) {
                bc[n][k] = ( bc[n-1][k-1] + bc[n-1][k]) % MOD;
            }
        }

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            long total = 0;
            for (int i = 0; i <= M; i++) {
                long first = i % 2 == 0 ? 1 : -1; // 부호
                long second = bc[M][i]; // 조합
                long third = pow(M-i,N); // 제곱수
                long result = (((first*second) % MOD) * third ) % MOD;
                total = (total + result + MOD) % MOD;
            }

            System.out.println("#" + t + " " + total);
        }
    }
    // 제곱수
    public static long pow(long base, long expo) {
        long num = 1;

        while (expo > 0) {

            // 지수가 홀수일 경우, 지수를 줄이는 expo /= 2 처리가 안되므로 미리 결과 값에 base를 한번 곱해
            if (expo % 2 == 1) {
                num *= base;
                num %= MOD;
            }
            base = (base * base) % MOD;
            expo /= 2;
        }
        return num;
    }
}
