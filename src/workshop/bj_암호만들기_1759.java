package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_암호만들기_1759 {

    static int L, C;
    static char[] src;
    static char[] tgt;
    static boolean[] isMo; // 모음 구분

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        src = new char[C];
        tgt = new char[L];
        isMo = new boolean[C];
    }
}
