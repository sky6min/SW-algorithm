package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_구슬탈출2_13460 {

    static char[][] map;
    static boolean[][] redVisited;
    static boolean[][] blueVisited;
    static int N;
    static int M;
    static Node sred;
    static Node sblue;
    static int res = Integer.MAX_VALUE;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new char[N][M];
        redVisited = new boolean[N][M];
        blueVisited  = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(temp[j] == 'B' ) {
                    sblue = new Node(j,i,0);
                }
                if(temp[j] == 'R') {
                    sred = new Node(j,i,0);
                }
                map[i][j] = temp[j];
            }
        }

        redVisited[sred.y][sred.x] = true;
        blueVisited[sblue.y][sblue.x] = true;

        dfs(sred,sblue);

        System.out.println(res);
    }

    static void dfs(Node red, Node blue) {
        if(red.cnt > 10) res = -1;

        for(int i=0; i<4; i++) {

            // blue 공 탐색
            while(true) {
                //탐색 및 탈출 예외
                break;
            }

            // red공 탐색
            while(true) {
                // 탐색 및 성공 res max
                if(map[dy[i] + red.y][dx[i] + red.x] == '#') {
                    break;
                }

                if()



            }

            //dfs 전달(red위치, blue위치).

        }
    }

    static class Node{
        int x;
        int y;
        int cnt;

        public Node() {
        }

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
