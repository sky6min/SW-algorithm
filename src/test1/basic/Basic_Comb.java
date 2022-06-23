package test1.basic;

import java.util.Arrays;

public class Basic_Comb {

    static int src[] = {1,2,3,4,5};
    static int tgt[] = new int[3];

    public static void main(String[] args) {

        comb(0,0);
    }

    static void comb(int srcIdx, int tgtIdx) {
        if(tgtIdx == 3) {
            System.out.println(Arrays.toString(tgt));
            return;
        }

        if(srcIdx == 5) {
            return;
        }

        tgt[tgtIdx] = src[srcIdx];
        comb(srcIdx+1, tgtIdx+1);
        comb(srcIdx+1,tgtIdx);

    }
}
