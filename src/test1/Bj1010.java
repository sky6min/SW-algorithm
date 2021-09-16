package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1010 {

    static int N;
    static int M;
    static int src[];
    static int tgt[];
    static int COUNT;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            src = new int[M];
            tgt = new int[N];
            COUNT = 0;

            for(int i=0; i<M; i++) {
                src[i] = i;
            }

            comb(0,0);

            System.out.println(COUNT);
        }
        

    }

    static void comb(int srcIdx, int tgtIdx) {

        if(tgtIdx == N) {  // tgtIdx 0 ~
            COUNT++;
            return;
        }

        if(srcIdx == M) return;

        tgt[tgtIdx] = src[srcIdx];



        comb(srcIdx+1, tgtIdx+1);

        comb(srcIdx+1, tgtIdx);
    }
}
