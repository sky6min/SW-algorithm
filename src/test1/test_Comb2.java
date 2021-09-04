package test1;

import java.util.Arrays;

public class test_Comb2 {

    static int src[] = {1,2,3,4,5};
    static int tgt[] = new int[3];

    static int COUNT;
    // select 방문 처리 X   [1] [2] [3] 4 5   =>     1 2 [3] [4] [5]
    // 1 [2] 3 [4] [5]
    public static void main(String[] args) {

        comb(0,0);
        System.out.println(COUNT);

    }

    static void comb(int tgtIdx, int srcIdx) {   // for 문 안씀
        // 기저조건 작은 탈출 조건 => 큰 탈출 조건
        if(tgtIdx == 3) {
            System.out.println(Arrays.toString(tgt));
            COUNT++;
            return;
        }
        if(srcIdx == 5) {
            return;
        }

        tgt[tgtIdx] = src[srcIdx];
        // [1] [2] [3] 4 5   tgt[2] = 4   1 2 5   1 3 5  1 4 5  2 4 5     3 4 5 5C3 = 10

        // tgt[0] = 1,
        // 알고리즘
        comb(tgtIdx+1, srcIdx+1);
        // ***
        comb(tgtIdx, srcIdx+1);


    }

}
