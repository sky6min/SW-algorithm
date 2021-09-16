package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_9461_파도반수열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            long src[] = new long[101];
            src[1] = 1;
            src[2] = 1;
            src[3] = 1;
            src[4] = 2;
            src[5] = 2;

            for(int i=6; i<=N; i++) {
                src[i] = src[i-1] + src[i-5];
            }

            System.out.println(src[N]);
        }

    }
}
