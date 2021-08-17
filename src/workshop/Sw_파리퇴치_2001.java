package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_파리퇴치_2001 {

    static int[][] map;
    static int T, N, M, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t<= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = 0;
            for(int i=0; i< N-M+1; i++) {
                // 매ㅔ번 열 배열 계산
                // j-->N-1
                for(int j=0; j<N-M+1; j++) {
//                    max = Math.max(max,flyCount(i, j));
                }
            }

            System.out.println("#" + " " + max);
        }
    }

//    static int flyCount(int y, int x) {
//        int count = 0;
//        for (int i =y; i< y+M; i++) {
//
//        }
//    }

}
