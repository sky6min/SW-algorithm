package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_배열돌리기4_17406 {

    static int K, M, N;
    static int map[][];
    static Element e[];

    static Element tgt[];
    static boolean selected[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        e = new Element[K];
        tgt = new Element[K];
        selected = new boolean[K];


        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        e[0] = new Element();
        e[1] = new Element();
        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            e[k].r = Integer.parseInt(st.nextToken());
            e[k].c = Integer.parseInt(st.nextToken());
            e[k].s = Integer.parseInt(st.nextToken());
        }

        perm(0);

    }

    static void perm(int tgtIdx) {
        if(tgtIdx == K) {

            for(int i=0; i<K; i++) {
                rotate(tgt[i]);
            }

            return;
        }

        for(int i=0; i<K; i++) {
            if(selected[i]) continue;
            tgt[tgtIdx] = e[i];

            selected[i] = true;
            perm(tgtIdx+1);
            selected[i] = false;

        }
    }

    static void rotate(Element em) {


        int sy = em.r-em.s, ey = em.r+em.s;
        int sx = em.c-em.s, ex = em.c+em.s;

        while(true) {
            // 탈출
            if(ey-sy < 1 || ex-sx < 1) return;

            int temp = map[sy][sx];
            // 이동

            // top 행을 좌로 이동 (왼쪽으로)
            for (int i=sx; i< ex; i++) {
                map[sy][i] = map[sy][i+1];
            }

            // Right 열을 상으로 이동 (위쪽으로)
            for (int i= sy; i< ey; i++) {
                map[i][ex]  = map[i+1][ex];
            }

            // Bottom 행을 좌로 이동(오른쪽으로 이동)
            for (int i = ex; i > sx; i-- ) {
                map[ey][i] = map[ey][i-1];
            }
            // Left 열 을 하로 이동
            for (int i= ey; i >sy; i--) {
                map[i][sx] = map[i-1][sx];
            }
            //
            map[sy+1][sx] = temp;

            //좌표보정
            sy += 1;
            sx += 1;
            ey -= 1;
            ex -= 1;
        }


    }

    static class Element {
        int r;
        int c;
        int s;

    }
}
