package workshop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw1210 {

    static int[][] ladder = new int[100][100];
    static int sy, sx, ans;

    // 위로 이동하면서 delta 사용 이 때, 왼 혹은 오른쪽이 먼저 선택해서 가야함.
    static int[] dy = {0, 0, -1};
    static int[] dx = {-1, 1, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("SW_1210_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t=1; t<=10; t++) {
            br.readLine();

            for(int i=0; i<100 ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            // 시작좌표
            sy = 99;
            for(int i=0; i<100; i++) {
                if(ladder[99][i] == 2) {
                    sx = i;
                    break;
                }
            }

            int dir = 2; // 0:왼쪽,  1:오른쪽,  2:위쪽
            while(true) {

                // 위로 갈 경우 : 왼쪽 오른쪽이 갈 수 있으면 먼저 선택 아니면 위로 계속 간다.
                // 옆으로 갈 경우 : 위로 갈 수 있으면 위로 먼저 선택 아니면 그 방향으로 계속 간다.

                if (dir == 2) {
                    for(int d = 0; d< 3; d++) {
                        int ny = sy + dy[d];
                        int nx = sx + dx[d];

                        if(ny >= 0 && nx >= 0 && ny < 100 && nx < 100 && ladder[ny][nx] == 1) {
                            sy = ny;
                            sx = nx;
                            dir = d; //방향 전환
                            break;
                        }
                    }

                }else if (dir ==0 || dir == 1) {
                    int ny = sy + dy[2];
                    int nx = sx + dx[2];
                    if(ny >= 0 && nx >= 0 && ny < 100 && nx < 100 && ladder[ny][nx] == 1) {
                        sy = ny;
                        sx = nx;
                        dir = 2; //방향 전환
                    }else {
                        sy = sy + dy[dir];
                        sx = sx + dx[dir];
                    }
                }

                //꼭대기에 도착
                if( sy == 0) {
                    ans = sx;
                    break;
                }
            }
            System.out.println("#" + " " + ans);

        }
    }
}
