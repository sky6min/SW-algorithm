package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_반복수열_2331 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int src[] = new int[300000];
        int res = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int num = A;
        while(true) {
            src[num]++;
            if(src[num] == 3) {
                break;
            }
            int temp = num;
            num = 0;
            while(temp != 0) {
                int a = temp % 10;
                temp = temp / 10;
                num += Math.pow(a, P);
            }
        }

        for(int i=1; i<300000; i++) {
            if(src[i] == 1) {
                res++;
            }
        }

        System.out.print(res);
    }
}
