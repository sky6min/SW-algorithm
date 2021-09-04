package test1;

import java.util.Arrays;

public class test_Perm {
    static int COUNT = 0; // 총 갯수
    static int src[] = {1,2,3,4,5};  // 소스
    static int tgt[] = new int[3];  // 정답

    // 중복순열 X
    // 중복 허용 X

    // 1, 2, 3
    // 1, 2, 4
    // 1, 2, 5
    // 1 ,3, 4   탈출 시키고 1,3,4 찎음.
    //   ...
    // 1, 5, 4
    // 2, 1, 3
    //   ...
    // 3. 1. 2
    // 정형화된 알고리즘식
    // 외워야되요 전부를 그래서 내가 니 어깨 툭치고 순열... 만들수 있읋정도로
    // 재귀함수 틀을 외웠잖아요 -> 1단계 응용 이에요. 5P3

    static boolean select[] = new boolean[5];

    public static void main(String[] args) {

        perm(0);
        System.out.println(COUNT);

    }

    static void perm(int tgtIdx) {
        // 기저조건
        if(tgtIdx == 3) {
            System.out.println(Arrays.toString(tgt));
            COUNT++;
            return;
        }
        // 1 2 3
        // 1 2 3 4 5   ([1] 2 ([3] [4]) 5
        // 알고리즘
        for(int i=0; i<5; i++) {
            if(select[i]) continue;

            select[i] = true;
            tgt[tgtIdx] = src[i];

            perm(tgtIdx+1);
            select[i] = false;

        }

    }
}
