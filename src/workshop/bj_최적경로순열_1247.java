package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_최적경로순열_1247 {

    static int N, min;
    static int start[] = new int[2];
    static int end[] = new int[2];
    static int src[][];
    static int tgt[][];



    static boolean select[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());



        for(int t=0; t<T; t++) {
            N= Integer.parseInt(br.readLine());
            src = new int[N][2];
            tgt = new int[N][2];
            select = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;

            for(int n=0; n<N; n++) {
                src[n][0] = Integer.parseInt(st.nextToken());
                src[n][1] = Integer.parseInt(st.nextToken());
            }

            perm(0);
            System.out.println(min);

        }
    }

    static void perm(int tgtIdx) {
        //기저조건
        if(tgtIdx == N) {
            int sum = Math.abs(tgt[0][0]-start[0]) + Math.abs(tgt[0][1]-start[1]) + Math.abs(tgt[N-1][0]-end[0]) + Math.abs(tgt[N-1][1]-end[1]);

            for(int i=0; i<N-1; i++) {
                sum += Math.abs(tgt[i][0]-tgt[i+1][0]) + Math.abs(tgt[i][1]-tgt[i+1][1]);
            }

            min = Math.min(sum,min);
            return;
        }

        for(int i=0; i<N; i++) {
            if(select[i]) continue;

            tgt[tgtIdx][0] = src[i][0];
            tgt[tgtIdx][1] = src[i][1];

            select[i] = true;
            perm(tgtIdx+1);
            select[i] = false;
        }

    }
}
