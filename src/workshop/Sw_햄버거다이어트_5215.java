package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_햄버거다이어트_5215 {

    static int T, N, L, max;
    static Item[] src;
    static Item[] tgt = new Item[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            src = new Item[N];
            for (int i=0; i< N; i++) {
                st = new StringTokenizer(br.readLine());
                src[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            max = 0;
            comb(0, 0);

            System.out.println("#"+ t + " " + max);
        }

    }

    static void comb(int srcIdx, int tgtIdx) {
        // tgt 기저 조건
        // complete code
        if( tgtIdx == tgt.length) {
            //...
            int cal = 0;
            int point = 0;

            // 칼로리 합 계산
            for(int i=0; i< tgtIdx; i++) {
                cal += tgt[i].c;
            }

            if(cal <= L) {
                // 포인트 합 계산
                for(int i=0; i< tgtIdx; i++) {
                    point += tgt[i].p;
                }
                max = Math.max(max, point);
            }
            return;
        }
        // src 기저 조건 return
        if(srcIdx == N) return;

        tgt[tgtIdx] = src[srcIdx];

        comb(srcIdx + 1, tgtIdx + 1);
        comb(srcIdx + 1, tgtIdx);

    }


    static class Item {
        int p;
        int c;
        public Item(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
}
