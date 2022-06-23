package test1.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Basic_Perm {

    static int src[] = {1,2,3,4,5};
    static int tgt[] = new int[3];
    static boolean visited[] = new boolean[5];
    static int cnt = 0;
    public static void main(String[] args) {

        perm(0);

    }

    static void perm(int tgtIdx) {
        if(tgtIdx == 3) {
            cnt++;
            System.out.println(Arrays.toString(tgt));
            System.out.println(cnt);
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
