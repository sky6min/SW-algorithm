package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_스타트와링크_14889 {

    static int N, M;
    static int map[][];
    static int start[];
    static int link[];

    static int stgt[];
    static int ltgt[];

    static int sSum = 0;
    static int lSum = 0;

    static boolean visited1[];
    static boolean visited2[];

    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        M = N / 2;

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        start = new int[M];
        link = new int[M];

        comb(0,0);
        System.out.println(res/2);
    }


    static void comb(int srcIdx, int tgtIdx) {
        if(tgtIdx == M) {
            // 스타트팀 점수
            sSum = 0;
            stgt = new int[2];
            visited1 = new boolean[M];
            visited2 = new boolean[M];
            sPerm(0);

            // 링크팀 번호
            boolean confirm[] = new boolean[N];
            for(int i=0; i<M; i++) {
                confirm[start[i]] = true;
            }

            int k = 0;
            for(int i=0; i<N; i++) {
                if(!confirm[i]) {
                    link[k++] = i;
                }
            }

            // 링크팀 점수
            lSum = 0;
            ltgt = new int [2];
            lPerm(0);


            res = Math.min(res, Math.abs(sSum-lSum));

            return;
        }

        if(srcIdx == N) {
            return;
        }

        start[tgtIdx] = srcIdx;
        comb(srcIdx+1, tgtIdx+1);
        comb(srcIdx+1, tgtIdx);

    }

    static void sPerm(int srcIdx) {
        if(srcIdx == 2) {
            sSum += map[stgt[0]][stgt[1]];
            sSum += map[stgt[1]][stgt[0]];

            return;
        }

        for(int i=0; i<M; i++) {
            if(visited1[i]) continue;
            stgt[srcIdx] = start[i];
            sPerm(srcIdx+1);
            visited1[i] = false;
        }

    }

    static void lPerm(int srcIdx) {
        if(srcIdx == 2) {
            lSum += map[ltgt[0]][ltgt[1]];
            lSum += map[ltgt[1]][ltgt[0]];

            return;
        }

        for(int i=0; i<M; i++) {
            if(visited2[i]) continue;
            ltgt[srcIdx] = link[i];
            lPerm(srcIdx+1);
            visited2[i] = false;
        }

    }
}
