package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_말이되고픈원숭이_1600 {

    static int K, W, H;
    static boolean visited[][][];
    static int map[][];

    static Queue<Node> queue = new LinkedList<Node>();

    static int dx[] = {1, 0, -1, 0};  // 우 하 좌 상
    static int dy[] = {0, 1, 0, -1};
    static int hdx[] = {};
    static int hdy[] = {};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][2];

        for(int i=0; i<H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }



    }

    void bfs() {

    }

    static class Node {
        int x;
        int y;
        int p;
        int d;

        public Node(int x, int y, int p, int d) {
            this.x = x;
            this.y = y;
            this.p = p;
            this.d = d;
        }
    }
}
