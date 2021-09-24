package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_연구소_14502ans2 {

    static int N, M, max;
    static int[][] map, wallMap, virusMap;
    static boolean[][] visit;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = { 0, 0,-1, 1};

    static ArrayList<Node> zero = new ArrayList<Node>();  // src
    static int zeroSize;

    static int[][] wall = new int[3][2];  // tgt

    static Queue<Node> queue = new LinkedList<Node>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if(n == 0) zero.add(new Node(i,j));
            }
        }

        zeroSize = zero.size();
        comb(0,0);

        System.out.println(max);
    }

    static void comb(int srcIdx, int tgtIdx) {
        if( tgtIdx == 3 ) {
            virus();
            return;
        }

        if(srcIdx == zeroSize) return;

        wall[tgtIdx][0] = zero.get(srcIdx).y;
        wall[tgtIdx][1] = zero.get(srcIdx).x;

        comb(srcIdx + 1, tgtIdx +1);
        comb(srcIdx + 1, tgtIdx);

     }

    static void wall (int cnt) {

        if(cnt == 3) {
            virus();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(wallMap[i][j] == 0) {
                    wallMap[i][j] = 1;
                    wall(cnt+1);
                    wallMap[i][j] = 0;
                }
            }
        }

    }

    static void virus() {
        visit = new boolean[N][M];
        virusMap = new int[N][M];

        //map 복사
        for (int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                virusMap[i][j] = wallMap[i][j];   // 벽이 세워져 있다.
            }
        }

        // virus queue 에 넣는다.
        for(int i=0; i< N; i++) {
            for(int j=0; j<M; j++) {
                if(virusMap[i][j] == 2) {
                    visit[i][j] = true;
                    queue.offer(new Node(i,j));
                }
            }
        }

        // visit 확산
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            for(int i=0; i<4; i++) {
                int ny = n.y + dy[i];
                int nx = n.x + dx[i];
                if(ny <0 || nx<0 || ny>=N || nx>= M || visit[ny][nx]) continue;
                if( virusMap[ny][nx] == 0 ) {
                    virusMap[ny][nx] = 2;
                    visit[ny][nx] = true;
                    queue.offer(new Node(ny, nx));
                }
            }
        }

        int sum = 0;
        for(int i=0; i<N ; i++) {
            for(int j=0; j<M; j++) {
                if(virusMap[i][j] == 0 ) sum++;
            }
        }
        max= Math.max(max,sum);
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


}
