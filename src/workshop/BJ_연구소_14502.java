package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_연구소_14502 {

    static int tgt[][] = new int[3][2];
    static int map[][];
    static int dx[] = {0,1,0,-1};  // 상 우 하 좌
    static int dy[] = {-1,0,1,0};
    static boolean visited[][];
    static int max = Integer.MIN_VALUE;
    static int cnt = 0;
    static int N, M;

    static Queue<Node> queue = new LinkedList<Node>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }

        }
        // 벽을 3개 놓는 조합.
        comb(0, 0);

        System.out.println(max);
    }

    static void comb(int tgtIdx, int srcIdx) {
        // 기저조건
        if(tgtIdx == 3) {
            cnt = 0;
            // 벽 설치
            map[tgt[0][0]][tgt[0][1]] = 1;
            map[tgt[1][0]][tgt[1][1]] = 1;
            map[tgt[2][0]][tgt[2][1]] = 1;
            visited = new boolean[N][M];
            // 각 2지점 마다 bfs 수행
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j] == 2) {
                        int sx = j;
                        int sy = i;
                        visited[sy][sx] = true;
                        queue.offer(new Node(sx,sy));
                        bfs();

                    }


                }
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(!visited[i][j]) {
                        if(map[i][j] != 1) cnt += 1;
                    }
                }
            }
            map[tgt[0][0]][tgt[0][1]] = 0;
            map[tgt[1][0]][tgt[1][1]] = 0;
            map[tgt[2][0]][tgt[2][1]] = 0;
            max = Math.max(max, cnt);
            return;
        }

        if(srcIdx == N*M) {
            return;
        }

        if(map[srcIdx/M][srcIdx%M] == 2 || map[srcIdx/M][srcIdx%M] == 1) {
            comb(tgtIdx, srcIdx + 1);
        }else {
            tgt[tgtIdx][0] = srcIdx / M;    // tgt[tgtIdx][0] y좌표
            tgt[tgtIdx][1] = srcIdx % M;    // tgt[tgtIdx][1] x좌표
            comb(tgtIdx+1, srcIdx+1);
            comb(tgtIdx, srcIdx + 1);
        }


    }

    static void bfs() {


        while(!queue.isEmpty()) {
            Node n = queue.poll();
            for(int i=0; i<4; i++) {
                int rx = n.x + dx[i];
                int ry = n.y + dy[i];

                if(rx < 0 || rx >= M || ry < 0 || ry >=N || map[ry][rx] == 1 || visited[ry][rx]) continue;

                visited[ry][rx] = true;
                queue.offer(new Node(rx,ry));

            }

        }

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
