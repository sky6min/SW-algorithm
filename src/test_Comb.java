import java.util.Arrays;

public class test_Comb {

    static int src[] = {1,2,3,4,5};
    static int tgt[] = new int[3];
    int COUNT;
    public static void main(String[] args) {
        comb(0,0);
    }


    static void comb(int tgtIdx, int srcIdx) {
        if(tgtIdx == 3) {
            System.out.println(Arrays.toString(tgt));
            return;
        }

        if(srcIdx == 5) return;

        tgt[tgtIdx] = src[srcIdx];

        comb(tgtIdx+1, srcIdx+1);
        comb(tgtIdx+1, srcIdx);

    }
}
