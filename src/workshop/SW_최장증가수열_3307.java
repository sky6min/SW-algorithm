package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_최장증가수열_3307 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int ary[] = new int[N];
            int LIS[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                ary[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            for(int i=0; i<N; i++) {
                LIS[i] = 1;
                for(int j=0; j<i; j++) {
                    if(ary[j] < ary[i] && LIS[j] > LIS[i] - 1 ) {
                        LIS[i] = LIS[j] + 1;
                    }
                }
                max = Math.max(LIS[i], max);
            }
            System.out.println("#" + t +  " " + max);
        }
    }
}
