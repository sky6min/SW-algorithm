package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_토마토_7576 {

    static int M, N, max;
    static int map[][];

    static Queue<Node> q = new LinkedList<Node>();
    static int dx[] = {-1, 0, 1, 0};   // 좌 상 우 하
    static int dy[] = { 0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) q.offer(new  Node(i,j,0));
            }
        }

        // 알고리즘
        while( !q.isEmpty()) {
            Node p = q.poll();
            int y = p.y;
            int x = p.x;

            max = Math.max(max, p.d);

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if( ny <0 || nx<0 || ny>= N || nx >= M) continue;

                if(map[ny][nx] == 0) {   // 익지 않은 토마토
                    map[ny][nx] = map[y][x] + 1;
                    q.offer(new Node(ny, nx, p.d+1));
                }
            }
        }

        // 혹시 고립된 토마토 0이 있나 없나
        for( int i=0; i< N; i++) {
            for(int j=0; j < M; j++) {
                if (map[i][j] == 0 ) {
                    System.out.println("-1");
                    return ;
                }
            }
        }

        System.out.println(max);
    }



    static class Node{
        int x;
        int y;
        int d;

        public Node(int y, int x, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}