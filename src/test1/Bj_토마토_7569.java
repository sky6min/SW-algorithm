package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_토마토_7569 {

    static int N, M, H;
    static int map[][][];
    static int dx[] = {1, 0, -1, 0, 0, 0};
    static int dy[] = {0, 1, 0, -1, 0, 0};
    static int dz[] = {0, 0, 0,  0, 1,-1};

    static Queue<Node> queue = new LinkedList<Node>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][M][N];


        for(int h = 0; h < H; h++) {
            for(int m = 0; m < M; m++) {
                for(int n = 0; n < N; n++) {
                    st = new StringTokenizer(br.readLine());
                    int value = Integer.parseInt(st.nextToken());
                    map[h][m][n] = value;
                    if(value == 1) {
                        queue.add(new Node(n,m,h,0));
                    }

                }
            }
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 6; i++) {
                int rx = node.x + dx[i];
                int ry = node.y + dy[i];
                int rz = node.z + dz[i];
                if(rx )
            }
        }

    }

    static class Node{
        int x;
        int y;
        int z;
        int val;

        Node(int x, int y, int z, int val) { this. x = x; this.y = y; this.z = z; this.val = val;}
    }
}
