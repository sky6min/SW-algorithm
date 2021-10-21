package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// dfs로 풀면안되는 문제  bfs로 풀어야한다.
public class bj_말이되고픈원숭이_1660ans {
    static int K;
    static int W, H;
    static int map[][];
    static boolean visited[][][];
    static int min = Integer.MAX_VALUE;

    static int dx[] = {-1, 0, 1, 0};   // 좌 하 우 상
    static int dy[] = { 0, 1, 0,-1};

    static int hdx[] = {1,2,2,1,-1,-2,-2,-1};
    static int hdy[] = {2,1,-1,-2,-2,-1,1,2};

    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        for(int i=0; i<H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0][K] = true;
        //dfs(0,0,K,0);
        bfs();
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    static void bfs() {
        queue.offer(new Node(0,0,K,0));
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(n.x == W-1 && n.y == H-1) {
                min = Math.min(min, n.cnt);
            }

            for(int i=0; i<4; i++) {
                int ry = n.y + dy[i];
                int rx = n.x + dx[i];

                if(ry < 0 || rx < 0 || ry >= H || rx >= W || map[ry][rx] == 1 || visited[ry][rx][n.k]) continue;
                visited[ry][rx][n.k] = true;
                queue.offer(new Node(rx,ry,n.k,n.cnt+1));
            }
            if(n.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int ry = n.y + hdy[i];
                    int rx = n.x + hdx[i];
                    if (ry < 0 || rx < 0 || ry >= H || rx >= W || map[ry][rx] == 1 || visited[ry][rx][n.k - 1])
                        continue;
                    visited[ry][rx][n.k - 1] = true;
                    queue.offer(new Node(rx, ry, n.k - 1, n.cnt + 1));

                }
            }

        }

    }

    // n = H  , m = W
    static void dfs(int n, int m, int k, int cnt) {
        // 기저조건
        if(n == H-1 && m == W-1) {
            min = Math.min(min, cnt+1);
        }

        // 원숭이로 이동
        for(int i=0; i<4; i++) {
            int rx = dx[i] + m;
            int ry = dy[i] + n;
            if(ry < 0 || rx < 0 || ry >= H || rx >= W || map[ry][rx] == 1 || visited[ry][rx][k]) continue;
            visited[ry][rx][k] = true;
            dfs(ry,rx,k,cnt+1);
        }

        // 말로 이동
        if(k > 0) {
            for(int i=0; i<8; i++) {
                int rx = hdx[i] + m;
                int ry = hdy[i] + n;
                if(ry < 0 || rx < 0 || ry >= H || rx >= W || map[ry][rx] == 1 || visited[ry][rx][k-1]) continue;
                visited[ry][rx][k-1] = true;
                dfs(ry,rx,k-1, cnt+1);
            }
        }
    }

    static class Node {
        private int x;
        private int y;
        private int k;
        private int cnt;

        public Node(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }
}
