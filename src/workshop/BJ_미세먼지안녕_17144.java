package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_미세먼지안녕_17144 {

    static int map[][];
    static int map2[][];
    static int R, C, T;
    static Queue<Node> queue = new LinkedList<Node>();
    static int dx[] = { 0, 1,  0,-1};  // 하 우 상 좌
    static int dy[] = { 1, 0, -1, 0};

    static int dx2[] = { 0, 1, 0, -1};  // 상 우 하 좌
    static int dy2[] = { -1, 0, 1, 0};  //

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sxac[] = new int[2];
        int syac[] = new int[2];
        int z = 0;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        map2 = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = map2[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) {
                    sxac[z] = j;
                    syac[z] = i;
                    z++;
                }
            }
        }

        for( int t = 0; t < T; t++) {
            // 먼지 다 넣기
            for (int i = 0; i < R; i++) {

                for (int j = 0; j < C; j++) {
                    if(map[i][j] > 0) {
                        queue.offer(new Node(j,i));
                    }

                }
            }

            // 먼지 처리
            while(!queue.isEmpty()) {
                Node n = queue.poll();
                for(int i=0; i<4; i++) {
                    int nx = n.x + dx[i];
                    int ny = n.y + dy[i];
                    if( nx < 0 || nx >= C || ny < 0 || ny >= R || map[ny][nx] == -1 ) continue;

                    map2[ny][nx] += map[n.y][n.x] / 5;
                    map2[n.y][n.x] = map2[n.y][n.x] - map[n.y][n.x] / 5;
                }
            }

            // 에어컨 윗 map 돌리기
            int dir = 0;
            int sx = sxac[0];
            int sy = syac[0];
            while(true) {
                if(sx + dx2[dir] >= C || sx+dx2[dir] < 0 || sy + dy2[dir] > syac[0] || sy + dy2[dir] < 0) {
                    dir++;
                    continue;
                }
                if(map2[sy][sx] == -1) {
                    map2[sy][sx] = -1;
                } else if (map2[sy+dy2[dir]][sx+dx2[dir]] == -1) {
                    map2[sy][sx] = 0;
                    break;
                } else {
                    map2[sy][sx] = map2[sy + dy2[dir]][sx + dx2[dir]];
                }

                sx += dx2[dir];
                sy += dy2[dir];


            }

            // 에어컨 아래 map 돌리기
            dir = 0;
            sx = sxac[1];
            sy = syac[1];
            while(true) {
                if(sx + dx[dir] >= C || sx+dx[dir] < 0 || sy + dy[dir] >= R || sy + dy[dir] < syac[1]) {
                    dir++;
                    continue;
                }
                if(map2[sy][sx] == -1) {
                    map2[sy][sx] = -1;
                } else if (map2[sy+dy[dir]][sx+dx[dir]] == -1) {
                    map2[sy][sx] = 0;
                    break;
                } else {
                    map2[sy][sx] = map2[sy + dy[dir]][sx + dx[dir]];
                }

                sx += dx[dir];
                sy += dy[dir];


            }
            // map 복사
            for (int i = 0; i < R; i++) {

                for (int j = 0; j < C; j++) {
                    map[i][j] = map2[i][j];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < R; i++) {

            for (int j = 0; j < C; j++) {
                if(map[i][j] != -1) {
                    sum += map[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    static class Node{
        int x;
        int y ;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
