package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_나무자르기_2805 {

    static int max = Integer.MIN_VALUE;
    static int ary[];
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ary = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
            max = Math.max(ary[i], max);
        }

        int top = max;
        int bottom = 0;

        while(bottom<top) {
            int cut = (top + bottom) / 2;
            long res = 0;

            for(int i=0; i<n; i++) {
                if(ary[i] - cut >= 0) {
                    res += (ary[i] - cut);

                }

            }

            if(res >= m) {
                bottom = cut+1;

            }
            if(res < m) {
                top = cut;

            }

        }

        System.out.println(bottom - 1);

    }
}
