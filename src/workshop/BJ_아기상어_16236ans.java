package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_아기상어_16236ans {

    static int N, sy, sx, sSize, sEatCnt, ans;
    static int[][] map;
    static boolean[][] visit;

    static Queue<Node> queue = new LinkedList<Node>();

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = { 0, 0,-1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 9) {
                    sy = i;
                    sx = j;
                }
                map[i][j] = n;
            }
        }

        // 상어 크기 초기화
        sSize = 2;

        while(true) {
            int cnt = bfs();
            if(cnt == 0 ) break;
            ans += cnt;


        }

        System.out.println(ans);
    }

    // 찾은 먹이가 있다면 그 먹이를 찾아 가는 이동 시간 ( 몇칸 == 몇초 ) 리턴
    // 못찾으면 0 리턴
    static int bfs() {
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int minDis = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N ; j++) {
                visit[i][j] = false;
            }
        }

        visit[sy][sx] = true;
        queue.offer(new Node(sy,sx, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            // 먹을 수 있는 물고기를 발견하면, min값을 설정
            if( map[node.y][node.x] != 0 && map[node.y][node.x] < sSize) {
                if( node.d < minDis) {
                    minDis = node.d;
                    minY = node.y;
                    minX = node.x;
                }else if(node.d == minDis) {
                    if( node.y < minY) {
                        minDis = node.d;
                        minY = node.y;
                        minX = node.x;
                    }else if(node .y == minY) {
                        if (node.x < minX) {
                            minDis = node.d;
                            minY = node.y;
                            minX = node.x;
                        }
                    }
                }
            }

            //가지치기
            if (node.d + 1 >= minDis ) continue;

            // 계속 다음 물고기를 찾아간다.
            for(int i=0; i< 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(ny <0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] > sSize) continue;
                visit[ny][nx] = true;
                queue.offer(new Node(ny, nx, node.d + 1));

            }

        }

        // 탐색이 끝나면 (queue 소진)
        if( minDis == Integer.MAX_VALUE ) return 0; // 못찾았다.
        else {
            sEatCnt++;
            if (sEatCnt == sSize ) {
                sSize++;
                sEatCnt = 0;
            }
            map[minY][minX] = 0;
            map[sy][sx] = 0;

            sy = minY;
            sx = minX;

            return minDis;
        }
    }


    static class Node{
        int y;
        int x;
        int d;

        public Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;

        }

    }
}
