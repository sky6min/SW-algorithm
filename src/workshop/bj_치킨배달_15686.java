package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_치킨배달_15686 {

    static int N, M, num;
    static int map[][];
    static Chick srcChick[];
    static Chick tgtChick[];
    static int min, sum, res;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sum = 0;
        res = Integer.MAX_VALUE;
        map = new int[N][N];
        srcChick = new Chick[13];
        tgtChick = new Chick[M];

        for(int i=0; i<13; i++) {
            srcChick[i] = new Chick();
        }
        for(int i=0; i<M; i++) {
            tgtChick[i] = new Chick();
        }

        num = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    srcChick[num].x = j;
                    srcChick[num].y = i;
                    num = num + 1;
                }
            }
        }

        for(int i=1; i<=M; i++) {
            comb(0,0, i);
        }
        System.out.println(res);
    }

    private static void comb(int srcIdx, int tgtIdx, int max) {
        if(tgtIdx == max) {

            sum = 0;
            for(int i=0; i<N; i++) {

                for(int j=0; j<N; j++) {
                    min = Integer.MAX_VALUE;
                    if(map[i][j] == 1) {
                        for(int k=0; k<max; k++) {
                            int dist = Math.abs(tgtChick[k].x - j) + Math.abs(tgtChick[k].y - i);
                            min = Math.min(min,dist);
                        }
                        sum += min;
                    }

                }
            }
            res = Math.min(res,sum);
            return;
        }
        if(srcIdx == num) return;

        tgtChick[tgtIdx].x = srcChick[srcIdx].x;
        tgtChick[tgtIdx].y = srcChick[srcIdx].y;

        comb(srcIdx+1,tgtIdx+1,max);
        comb(srcIdx+1,tgtIdx,max);

    }

    static class Chick{
        int x;
        int y;

        public Chick() {
        }

        public Chick(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
