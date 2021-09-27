package CT_workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_이항계수1_11050 {
    static int src[];
    static int tgt[];
    static int total;
    static int num;
    static int cnt;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        total = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        src = new int[total];
        tgt = new int[num];

        comb(0,0);
        System.out.println(cnt);

    }

    static void comb(int srcIdx, int tgtIdx) {
        if(tgtIdx == num) {
            cnt++;
            return;
        }

        if(srcIdx == total) {
            return;
        }

        tgt[tgtIdx] = src[srcIdx];

        comb(srcIdx+1, tgtIdx+1);

        comb(srcIdx+1, tgtIdx);
    }

}
