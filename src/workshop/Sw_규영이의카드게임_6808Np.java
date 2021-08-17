package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw_규영이의카드게임_6808Np {

    static int T, win, lose, N=9;
    static int[] input = new int[19];
    static int[] guCard = new int[9]; // 주어진다.
    static int[] inCard = new int[9]; // 나머지 카드들 => 순열 경우의 수 => src
    static int[] tgt = new int[9];

    // static boolean[] select = new boolean[N];

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


            //perm(0);
            // 가장 작은 수에서 출발 - 정렬 확인
            while(true) {

                //complete code
                check();

                if( !np() ) break;
            }

            // 출력
            System.out.println("#" + t + " " + win + " " + lose);
        }
    }

    static boolean np() {
        // 1. 오름차순이 끝나는 지점 -1 과 뒤에서부터 그 지점보다 큰수를 스와핑
        // 2. 오름차순이 끝나는 지점부터 그 뒤까지 스와핑
        int[] src = inCard;

        int i = src.length - 1;
        while( i >= 0 && src[i-1] >= src[i] ) --i; // 1-2-3-4-5

        // 기저조건
        if( i == 0 ) return false; // 현재 배열의 구성이 가장 큰 수다 (마지막이다)


        int j = src.length - 1;
        while(src[i-1] >= src[j]) -- j;
        swap(src, i-1, j);

        int k = src.length - 1;
        while ( i < k) {
            swap( src, i++, k--);
        }

        return true;
    }

    static void swap(int num[], int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;

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
