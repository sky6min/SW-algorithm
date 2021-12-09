package test1;

import java.util.Arrays;

public class 중복조합 {

    static int tgt[] = new int[10];
    static int src[] = {0, 1};

    public static void main(String[] args) {

        comb(0,0);
    }


    static void comb(int tgtIdx, int srcIdx) {
        // tgtIdx가 Max에 도달하면 탈출
        if(tgtIdx == 10) {
            System.out.println(Arrays.toString(tgt));
            return;
        }
        // srcIdx가
        if(srcIdx == 2) {
            return;
        }
        tgt[tgtIdx] = src[srcIdx];
        comb(tgtIdx+1, srcIdx);

        comb(tgtIdx, srcIdx+1);

    }
}
