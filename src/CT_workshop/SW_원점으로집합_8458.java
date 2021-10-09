package CT_workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_원점으로집합_8458 {

    static long src[][];
    static long src2[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            src = new long[N][2];
            src2 = new long[N];
            int res = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            src[0][0] = Math.abs(Long.parseLong(st.nextToken()));
            src[0][1] = Math.abs(Long.parseLong(st.nextToken()));
            long init = (src[0][0] + src[0][1]) % 2;
            src2[0] = src[0][0] + src[0][1];
            long max = src2[0];
            for(int n=1; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                src[n][0] = Math.abs(Long.parseLong(st.nextToken()));
                src[n][1] = Math.abs(Long.parseLong(st.nextToken()));
                src2[n] = src[n][0] + src[n][1];
                max = Math.max(max, src2[n]);
                if( init != (src2[n] % 2)) {
                    res = -1;
                }

            }

            if(res == -1) {
                System.out.println("#" + t + " " + res);
                continue;
            }

            int i=0;

            while(true) {

                if(max <= res && (-max+res) % 2 == 0) {
                    break;
                }
                i++;
                res = res + i;
            }

            System.out.println("#" + t + " " + i);
        }
    }
}
