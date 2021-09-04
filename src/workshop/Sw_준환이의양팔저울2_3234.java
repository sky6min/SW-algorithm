package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_준환이의양팔저울2_3234 {
    static int T ,N , ans;
    static int[] choo;
    static int[][] memoi; // [추의 무게의 합][그 무게를 만드는 데 사용된 추의 정보] (5개 추라면 5자리의 0/1 가진다.)
//    static boolean[] select;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {

            N = Integer.parseInt(br.readLine());
            int[] choo = new int[N];
            boolean[] select = new boolean[N];

            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i< N; i++) {
                choo[i] = Integer.parseInt(st.nextToken());
                sum += choo[i];
            }

            memoi = new int[sum + 1][1 << N]; // 추가 5 00001 -> 10000
            ans = 0;

            perm(0,0,0,0);

            System.out.println("#" + t + " " + ans);

        }
    }
    // index : 0, 왼쪽 합, 오른쪽 합 매 단계에서 계산해서 다음 재귀 호출에 전달
    static int perm(int tgtIdx, int leftSum, int rightSum, int mask ) {
        //가지치기

        if(tgtIdx == N) {
            ans++;
            return 1;
        }

/*        if(rightSum > leftSum) return;

        for(int i=0; i< N; i++) {
            if(select[i]) continue;

            select[i] = true;
            perm(choo,select,tgtIdx+1, leftSum + choo[i], rightSum);
            perm(choo,select,tgtIdx+1, leftSum, rightSum + choo[i]);




            select[i] = false;
        }*/
        return 1;
    }
}
