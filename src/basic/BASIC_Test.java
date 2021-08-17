package basic;

import java.util.Arrays;

public class BASIC_Test {

    static int src[] = {1,2,3,4,5};
    static int tgt[] = new int[3];
    static int COUNT = 0;
    static boolean selected[] = new boolean[5];

    public static void combFunction() {
        comb(0,0);
        System.out.println(COUNT);
    }

    static void comb(int srcIdx, int tgtIdx) {
        //기저조건
        if(tgtIdx == tgt.length) {
            System.out.println(Arrays.toString(tgt));
            COUNT++;
            return;
        }

        for(int i=srcIdx; i<src.length; i++) {

            tgt[tgtIdx] = src[i];
            comb(i+1, tgtIdx+1);
        }
    }

    static void permFunction() {
        perm(0);
        System.out.println(COUNT);
    }

    static void perm(int tgtIdx) {
        //기저조건
        if(tgtIdx == tgt.length) {
            System.out.println(Arrays.toString(tgt));
            COUNT++;
            return;
        }

        for(int i=0; i<src.length; i++) {
            if(selected[i]) continue;

            tgt[tgtIdx] = src[i];
            selected[i] = true;
            perm(tgtIdx+1);
            selected[i] = false;

        }
    }


    public static void main(String[] args) {
        //combFunction();
        permFunction();
    }
}
