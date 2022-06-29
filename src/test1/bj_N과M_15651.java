package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_N과M_15651 {

    static int N, M;
    static int tgt[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tgt = new int[M];

        perm(0);
        System.out.print(sb);

    }

    static void perm(int n) {
        if(n==M) {
            for(int i=0; i<M; i++) {
                sb.append(tgt[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i=1; i<=N; i++) {
            tgt[n] = i;
            perm(n+1);
        }

    }
}
