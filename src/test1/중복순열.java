package test1;

import java.util.Arrays;

public class 중복순열 {
    static int src[] = {0, 1};
    static int tgt[] = new int[10];
    static int cnt = 0;


    public static void main(String[] args) {

        perm(0);
        System.out.println("총 개수 : " + cnt);
    }


    static void perm(int tgtIdx) {
        if(tgtIdx == 10) {
            cnt += 1;
            System.out.println(Arrays.toString(tgt));
            return;
        }

        for(int i=0; i<2; i++) {
            tgt[tgtIdx] = src[i];

            perm(tgtIdx+1);
        }

    }
}
