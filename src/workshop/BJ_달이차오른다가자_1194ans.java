package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_달이차오른다가자_1194ans {

    static int N, M;
    static char[][] map;
    static boolean[][][] visit;
    static int result = Integer.MAX_VALUE;

    static int[] dy = { 1, -1, 0, 0};
    static int[] dx = { 0, 0, -1, 1};

    static Queue<Node> queue = new LinkedList<Node>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M][1<<6];

        for(int i=0; i< N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == '0') {
                    visit[i][j][0] = true;
                    queue.offer(new Node(i,j,0,0));
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if( map[node.y][node.x] == '1') return node.d;

            for(int i=0; i< 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                int key = node.key;

                if( ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == '#') continue;

                // key - 획득
                // 0 0 0 1 0 0
                // 0 1 0 0 0 0
                if( 'a' <= map[ny][nx] && map[ny][nx] <= 'f' ) {
                    key |= ( 1 << map[ny][nx] - 'a' );
                }

                // key - 사용
                if( 'A' <= map[ny][nx] && map[ny][nx] <= 'F' ) {
                    if( (key & ( 1 << map[ny][nx] - 'A' )) == 0 ) continue;
                }

                if( visit[ny][nx][key] ) continue;

                visit[ny][nx][key]= true;
                queue.offer(new Node(ny ,nx, key, node.d+1));
            }
        }
        return -1;
    }

    static class Node {
        int y;
        int x;
        int d;  // depth
        int key;
        public Node(int y, int x, int key, int d) {
            this.y= y;
            this.x= x;
            this.key =key;
            this.d = d;
        }

    }

}
