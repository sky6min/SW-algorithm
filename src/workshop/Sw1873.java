package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw1873 {

    static  int H, W;
    static char[][] map;
    static char[] command;
    static int[] dx = {0, 0, -1, 1}; // up down left right
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];

            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int stat=0, sx=0, sy=0;
            for(int i=0; i< H; i++) {
                for(int j=0; j<W; j++) {
                    if(map[i][j] == '^'){
                        sx = j;
                        sy = i;
                        stat = 0;
                    }else if(map[i][j] == 'v') {
                        sx = j;
                        sy = i;
                        stat = 1;
                    }else if(map[i][j] == '<') {
                        sx = j;
                        sy = i;
                        stat = 2;
                    }else if(map[i][j] == '>') {
                        sx = j;
                        sy = i;
                        stat = 3;
                    }
                }
            }

            int cmd = Integer.parseInt(br.readLine());
            command = br.readLine().toCharArray();

            int rx =0, ry=0;
            for (int c = 0; c < cmd; c++) {
                if (command[c] == 'U') {
                    stat = 0;
                    if(sy+dy[0] < 0 || map[sy+dy[0]][sx] != '.' ) {map[sy][sx] = '^'; continue; }
                    map[sy][sx] = '.';
                    map[sy+dy[0]][sx] = '^';
                    sy = sy+dy[0];
                    sx = sx+dx[0];

                } else if (command[c] == 'D') {
                    stat = 1;
                    if(sy+dy[1] >= H || map[sy+dy[1]][sx] != '.' ) { map[sy][sx] = 'v'; continue; }
                    map[sy][sx] = '.';
                    map[sy+dy[1]][sx] = 'v';
                    sy = sy+dy[1];
                    sx = sx+dx[1];

                } else if (command[c] == 'L') {
                    stat = 2;
                    if(sx+dx[2] < 0 || map[sy][sx+dx[2]] != '.' ) {map[sy][sx] = '<'; continue;}
                    map[sy][sx] = '.';
                    map[sy][sx+dx[2]] = '<';
                    sy = sy+dy[2];
                    sx = sx+dx[2];

                } else if (command[c] == 'R') {
                    stat = 3;
                    if(sx+dx[3] >= W || map[sy][sx+dx[3]] != '.' ) { map[sy][sx] = '>'; continue; }
                    map[sy][sx] = '.';
                    map[sy][sx+dx[3]] = '>';
                    sy = sy+dy[3];
                    sx = sx+dx[3];

                }else if (command[c] == 'S') {
                    rx = sx + dx[stat];
                    ry = sy + dy[stat];
                    while(true) {
                        if(rx >=W || rx <0 || ry <0 || ry >=H || map[ry][rx] == '#' ) {
                            break;
                        }else if(map[ry][rx] == '*') {
                            map[ry][rx] = '.';
                            break;
                        }
                        rx += dx[stat];
                        ry += dy[stat];
                    }
                }

            }
            System.out.println(t);
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
