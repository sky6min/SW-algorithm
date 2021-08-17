package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw_규영이의카드게임_6808ans {

    static int T, win, lose, N=9;
    static int[] input = new int[19];
    static int[] guCard = new int[9]; // 주어진다.
    static int[] inCard = new int[9]; // 나머지 카드들 => 순열 경우의 수 => src
    static int[] tgt = new int[9];

    static boolean[] select = new boolean[N];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            // 초기화
            win = 0;
            lose = 0;
            Arrays.fill(input, 0);

            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 규영이 카드
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                input[num] = 1;
                guCard[i] = num;
            }
            // 인영이 카드
            int num = 0;
            for (int i = 1; i <= 18; i++) {
                if( input[i] == 0 ) {
                    inCard[num++] = i;
                }
            }


            perm(0);

            // 출력
            System.out.println("#" + t + " " + win + " " + lose);
        }
    }

    static void perm(int tgtIdx) {
        // 기저조건
        if( tgtIdx == N ) {
            // complete code
            check();
            return;
        }

        for (int i = 0; i < N; i++) {
            if( select[i] ) continue;

            tgt[tgtIdx] = inCard[i];
            select[i] = true;
            perm(tgtIdx + 1);
            select[i] = false;
        }
    }

    static void check() {
        // 인영 카드 순열과 규영 카드 시합
        int guSum = 0;
        int inSum = 0;
        for (int i = 0; i < N; i++) {
            if( guCard[i] > tgt[i] ) guSum += guCard[i] + tgt[i];
            else inSum += guCard[i] + tgt[i];
        }
        if( guSum > inSum ) win++;
        else if( guSum < inSum ) lose++;
    }
}
