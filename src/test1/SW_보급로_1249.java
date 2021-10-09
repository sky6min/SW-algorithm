package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_보급로_1249 {

    static int N;
    static int dx[] = {-1, 0, 1, 0};  // 좌 하 우 상
    static int dy[] = { 0, 1, 0,-1};
    static int map[][];
    static int dist[][];
    static boolean visit[][];

    static PriorityQueue<Node> pq = new PriorityQueue<Node>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];
            visit= new boolean[N][N];
            for(int i=0; i<N; i++) {
                String str = br.readLine();
                for(int j=0; j<N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            for(int i=0; i<N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            visit[0][0] =true;
            Node node = new Node(0,0,map[0][0]);
            pq.offer(node);
            dist[0][0] = node.cost;

            while(!pq.isEmpty()) {
                Node n = pq.poll();
                visit[n.y][n.x] = true;

                for(int i=0; i<4; i++) {
                    int nx = n.x+dx[i];
                    int ny = n.y+dy[i];
                    if(nx < 0 || ny <0 || nx >= N || ny >= N || visit[ny][nx]) continue;
                    if(dist[ny][nx] != Math.min(dist[ny][nx], n.cost+map[ny][nx])){
                        dist[ny][nx] = n.cost+map[ny][nx];
                        Node nNode = new Node(nx,ny, dist[ny][nx]);
                        pq.offer(nNode);
                    }

                }

            }

            System.out.println("#" + t + " " + dist[N-1][N-1]);
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
