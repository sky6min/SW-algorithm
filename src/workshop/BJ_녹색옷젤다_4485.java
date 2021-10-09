package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_녹색옷젤다_4485 {

    static int N;
    static int map[][];
    static boolean visited[][];
    static int D[][];    // 최소길이 배열
    static PriorityQueue<Node> pq;

    static int dx[] = {0, 1, 0, -1};  // 상 우 하 좌
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        while(true) {
            t = t + 1;
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            map = new int[N][N];
            D = new int[N][N];
            visited = new boolean[N][N];
            pq = new PriorityQueue<Node>();
            for (int i = 0; i < N; i++) {
                Arrays.fill(D[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Dijkstra();
            System.out.println("Problem " + t +": " +D[N-1][N-1]);
        }
    }

    private static void Dijkstra() {
        Node n = new Node(0,0, map[0][0]);
        pq.offer(n);
        visited[0][0] = true;
        D[0][0] = n.cost;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.y][node.x] = true;
            for(int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[ny][nx]) continue;
                if(D[ny][nx] != Math.min(D[ny][nx], D[node.y][node.x] + map[ny][nx])) {
                    D[ny][nx] = D[node.y][node.x] + map[ny][nx];
                    pq.offer(new Node(nx,ny, D[ny][nx]));
                }


            }

        }

    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
