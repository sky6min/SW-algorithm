package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_병든나이트_1783 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로

        // 세로(N) >= 3, 가로(M) >= 7
        if(N >= 3 && M >= 7 ) {
            System.out.println(M - 2);


        }else {
            int res = 0;
            // 가로로 1칸씩 이동
            if(N >= 3) {
                for(int i=1; i<=M; i++) {
                    if(i >= 4) {
                        System.out.println(4);
                        return;
                    }
                    res += 1;
                }
                System.out.println(res);
            }else {    // 가로로 2칸씩 이동
                if(N == 1) {
                    System.out.println(1);
                    return;
                }else {
                    for(int i=1; i<=M; i=i+2) {
                        if(i >= 7) {
                            System.out.println(4);
                            return;
                        }
                        res += 1;
                    }
                    System.out.println(res);
                }
            }

            // 최대값이 4이면 탈출
        }

    }
}
