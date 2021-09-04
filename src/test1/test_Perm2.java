package test1;

import java.util.Arrays;

public class test_Perm2 {

    static int src[] = {1,2,3,4,5};
    static int tgt[] = new int[3];
    static int COUNT=0;

    static boolean visited[] = new boolean[5];
    public static void main(String[] args) {

        perm(0);
    }

    static void perm(int tgtIdx) {

        if(tgtIdx == 3) {
            System.out.println(Arrays.toString(tgt));
            return;
        }

        for(int i=0; i<5; i++) {
            if(visited[i]) continue;

            tgt[tgtIdx] = src[i];
            visited[i] = true;
            perm(tgtIdx+1);
            visited[i] = false;
        }

    }
}
