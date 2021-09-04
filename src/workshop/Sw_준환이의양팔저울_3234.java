package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw_준환이의양팔저울_3234 {

    static int N, total;
    static int src[];
    static int tgt[];
    static boolean select[];
    static int index[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++ ) {
            N = Integer.parseInt(br.readLine());
            src = new int[N];
            tgt = new int[N];
            select = new boolean[N];
            index = new int[N];
            total = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++) {
                src[n] = Integer.parseInt(st.nextToken());
                total += src[n];
            }

            for(int i=1; i<=N; i++) {
                Arrays.fill(select,false);
                perm(0,0,i);
            }
            System.out.println(total);
        }

    }

    static void perm(int tgtIdx, int sum, int n) {
        //기저조건
        if(tgtIdx == n) {
            // 오른쪽 조합
            comb(0,0,n);

            return;
        }

        for(int i=0; i<N; i++) {
            if(select[i]) continue;


            tgt[tgtIdx] = src[i];

            select[i] = true;
            sum += tgt[tgtIdx];  // sum은 오른쪽 합
            if(sum <= total-sum) {  // 오른쪽 <= 왼쪽이면
                perm(tgtIdx+1, sum , n);
            }
            select[i] = false;
            sum -= tgt[tgtIdx];

        }
    }

    static void comb(int tgtIdx, int srcIdx, int n) {
        // 2개를 고르면
        if(tgtIdx == n) {
            int lsum=0;
            int rsum=0;

            for (int i = 0; i < N; i++) {
                // 오른쪽이 왼쪽 보다 크면 탈출
                if(rsum > lsum) break;



            }

            return;
        }

        // 원소 끝이면
        if(srcIdx == N) return;

        // 몇번째로 오른쪽에 넣는지 차례번호
        index[tgtIdx] = srcIdx;

        comb(tgtIdx+1, srcIdx+1, n);
        comb(tgtIdx, srcIdx+1, n);

    }
}
