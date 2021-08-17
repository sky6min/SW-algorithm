package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_배열돌리기1_16926 {

    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read = br.readLine().split(" ");

        N = Integer.parseInt(read[0]);
        M = Integer.parseInt(read[1]);
        R = Integer.parseInt(read[2]);

        map = new int[N][M];
        for(int i=0; i< N; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        // R 회전
        for(int i=0; i < R; i++) {
            rotate();
        }

        for(int i=0; i< N; i++) {
            for(int j=0; j< M; j++) {
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
    }

    // 밖 -> 안 좁혀가면서 처리
    static void rotate() {



        int sy = 0, ey = N-1;
        int sx = 0, ex = M-1;

        while(true) {
            // 탈출
            if(ey-sy < 1 || ex-sx < 1) return;

            int temp = map[sy][sx];
            // 이동

            // top 행을 좌로 이동 (왼쪽으로)
            for (int i=sx; i< ex; i++) {
                map[sy][i] = map[sy][i+1];
            }

            // Right 열을 상으로 이동 (위쪽으로)
            for (int i= sy; i< ey; i++) {
                map[i][ex]  = map[i+1][ex];
            }

            // Bottom 행을 좌로 이동(오른쪽으로 이동)
            for (int i = ex; i > sx; i-- ) {
                map[ey][i] = map[ey][i-1];
            }
            // Left 열 을 하로 이동
            for (int i= ey; i >sy; i--) {
                map[i][sx] = map[i-1][sx];
            }
            //
            map[sy+1][sx] = temp;

            //좌표보정
            sy += 1;
            sx += 1;
            ey -= 1;
            ex -= 1;
        }
    }
}
