package test1;

import java.util.Arrays;

public class perm_practice {

    static int src[] = {1,2,3,4,5};
    static int tgt[] = new int[5];
    static boolean visited[] = new boolean[5];
    static int cnt = 0;

    public static void main(String[] args) {

        perm(0);
        System.out.println(cnt);
    }

    static void perm(int tgtIdx){
        if(tgtIdx == 5) {
            cnt++;
            System.out.println(Arrays.toString(tgt));

            return;
        }

        for (int i = 0; i < 5; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            tgt[tgtIdx] = src[i];
            perm(tgtIdx+1);
            visited[i] = false;
        }
    }
}
