package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_말이되고픈원숭이_1600 {

    static int K, W, H;
    static int[][] map;

    // visit 관리 항목 y, x, 말이동 횟수
    // 같은 y, x 이라도 말이동 횟수 남은 것에 따라 의미가 다를 수 있다.
    static boolean[][][] visit;

    // 하, 우, 상, 좌
    static int[] dy = { 1, 0, -1,  0 };
    static int[] dx = { 0, 1,  0, -1 };

    static int[] hdy = { 1,  1, -2, -2, -1, -1, 2,  2 };
    static int[] hdx = { 2, -2,  1, -1,  2, -2, 1, -1 };

    static Queue<Node> queue = new LinkedList<Node>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visit = new boolean[H][W][K+1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Node n = new Node(0,0,K,0);
        queue.offer(n);

        bfs();
    }

    static void bfs() {
        while( !queue.isEmpty() ) {
            Node node = queue.poll();



            // 목표도달 확인
            if( node.y == H-1 && node.x == W-1 ) {
                System.out.println(node.d);
                return;
            }

            //상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if( ny < 0 || nx <0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k]) continue;
                visit[ny][nx][node.k] = true;
                queue.offer(new Node(ny, nx, node.k, node.d+1));
            }


            if( node.k == 0) continue;

            // 말 탐색(조건 : node.k > 0 )
            for (int i = 0; i < 4; i++) {
                int ny = node.y + hdy[i];
                int nx = node.x + hdx[i];
                if( ny < 0 || nx <0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k-1]) continue;
                visit[ny][nx][node.k-1] = true;
                queue.offer(new Node(ny, nx, node.k-1, node.d+1));
            }
        }
        System.out.println(-1);
    }
    static class Node {
        int x;
        int y;
        int k;  // k: 말처럼 뛸 수 있는 남은 수
        int d;  // d : depth

        public Node(int x, int y, int k, int d) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.d = d;
        }
    }
}
