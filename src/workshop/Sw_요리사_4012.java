package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 조합 -> 순열
public class Sw_요리사_4012 {

    static int srcFood[];
    static int tgtFood[];
    static int tgtFood2[];
    static int N;
    static ArrayList<Integer> tgtBox = new ArrayList<Integer>();
    static ArrayList<Integer> tgtBox2 = new ArrayList<Integer>();

    static int map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            srcFood = new int[N];
            tgtFood = new int[N/2];
            tgtFood2 = new int[N/2];

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            comb(0,0);        // 전체 중 절반을 뽑는 경우의 수  ---> 절반 중 2개를 뽑고 계산 &

            
        }
    }

    static void comb(int tgt, int src) {
        if(tgt == N/2) {

        }
        if(src == N/2) return;



    }
}
