package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_도영이음식_2961 {

    static Taste src[];
    static Taste tgt[];
    static int min = 0;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        src = new Taste[N];
        tgt = new Taste[N];
        min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tgt[i] = new Taste();
            src[i] = new Taste();
            src[i].ts1 = Integer.parseInt(st.nextToken());
            src[i].ts2 = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            comb(0, 0, i);
        }

        System.out.println(min);
    }

    static void comb(int tgtIdx, int srcIdx, int max) {
        if(tgtIdx == max) {
            int ts1 = 1;
            int ts2 = 0;
            for(int i=0; i<max; i++) {
                ts1 = tgt[i].ts1 * ts1;
                ts2 = tgt[i].ts2 + ts2;
            }
            min = Math.min(min,Math.abs(ts1-ts2));
            return;
        }

        if(srcIdx == N) return;

        tgt[tgtIdx].ts1 = src[srcIdx].ts1;
        tgt[tgtIdx].ts2 = src[srcIdx].ts2;

        comb(tgtIdx+1, srcIdx+1, max);

        comb(tgtIdx, srcIdx+1, max);

    }

    static class Taste {
        int ts1;
        int ts2;

        public Taste() {

        }

        public Taste(int ts1, int ts2) {
            this.ts1 = ts1;
            this.ts2 = ts2;
        }
    }
}
