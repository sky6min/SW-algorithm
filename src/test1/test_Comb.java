package test1;

import java.util.Arrays;

public class test_Comb {

    static int src[] = {1,2,3,4,5};
    static int tgt[] = new int[3];
    static int COUNT = 0;
    static boolean selected[] = new boolean[5];
    public static void main(String[] args)
    {
        perm(0);
        System.out.println(COUNT);
    }


    static void perm(int tgtIdx) {

        if(tgtIdx == 3) {
            System.out.println(Arrays.toString(tgt));
            COUNT++;
            return;
        }

        for(int i=0; i<5; i++) {
            if(selected[i]) continue;
            tgt[tgtIdx] = src[i];
            selected[i] = true;

            perm(tgtIdx+1);
            selected[i] = false;
        }

    }
}
