package test1;

import java.util.Arrays;

public class comb_practice {
    static int src[] = {1,2,3,4,5};
    static int tgt[] = new int[3];
    int res = 0;

    public static void main(String[] args) {

        comb(0,0);
    }

    static void comb(int tgtIdx, int srcIdx) {
        if(tgtIdx == 3) {
            System.out.println(Arrays.toString(tgt));
            return;
        }
        if(srcIdx == 5) {

            return;
        }
        String res = "anaconda";
        char[] words =  res.toCharArray();


        tgt[tgtIdx] = src[srcIdx];
        comb(tgtIdx+1, srcIdx+1);
        comb(tgtIdx,srcIdx+1);

    }
}
