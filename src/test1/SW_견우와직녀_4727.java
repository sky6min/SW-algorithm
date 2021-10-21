package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_견우와직녀_4727 {

    static Queue<Node> queue = new LinkedList<Node>();
    static int map[][];
    static int res = Integer.MAX_VALUE;
    static int N, M;

    static int visited[][][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = { 0, 1, 0,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            res = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 맵크기
            N = Integer.parseInt(st.nextToken());
            // 쉬는시간
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new int[N][N][2];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 알고리즘
            Node node = new Node(0,0,1,0);
            queue.offer(node);

            while(!queue.isEmpty()) {
                Node n = queue.poll();

                if(n.x == N-1 && n.y == N-1) {
                    res = Math.min(res, n.N);
                    continue;
                }

                for(int i=0; i<4; i++) {
                    int nx = dx[i] + n.x;
                    int ny = dy[i] + n.y;
                    if(nx<0 || nx >= N || ny<0 || ny>=N) continue;

                    if(n.isAble == 1) {
                        if(map[n.y][n.x] != 1 && map[ny][nx] != 1) continue;

                        // 새로 가는 곳이 절벽이 아니다.
                        if(map[ny][nx] == 1) {
                            if(visited[ny][nx][n.isAble] == 0 || visited[ny][nx][n.isAble] >n.N + 1) {
                                visited[ny][nx][n.isAble] = n.N + 1;
                                queue.offer(new Node(nx,ny,1,n.N+1));
                            }
                            continue;
                        }
                        // 새로 가는 곳이 절벽이다.
                        if(map[ny][nx] == 0) {
                            if(visited[ny][nx][n.isAble] == 0) {
                                visited[ny][nx][n.isAble] = (n.N / M) * M + M;
                                queue.offer(new Node(nx,ny,0, (n.N / M) * M + M));
                            }
                        }else {
                            if(visited[ny][nx][n.isAble] == 0) {
                                int M = map[ny][nx];
                                visited[ny][nx][n.isAble]  = (n.N/ M) * M + M;
                                queue.offer(new Node(nx,ny,1, (n.N/ M) * M + M));
                            }
                        }

                    }else {
                        // 새로 가는 곳이 절벽이다.
                        if(map[ny][nx] == 0) continue;

                        // 새로 가는 곳이 절벽이 아니다
                        if(map[ny][nx] == 1) {
                            if(visited[ny][nx][n.isAble] == 0 || visited[ny][nx][n.isAble] >n.N + 1) {
                                visited[ny][nx][n.isAble] = n.N + 1;
                                queue.offer(new Node(nx,ny,0,n.N+1));
                            }
                            continue;
                        }else {
                            if(visited[ny][nx][n.isAble] == 0) {
                                int M = map[ny][nx];
                                visited[ny][nx][n.isAble]  = (n.N/ M) * M + M;
                                queue.offer(new Node(nx,ny,0, (n.N/ M) * M + M));
                            }
                        }

                    }




/*                    // 새로 가는 곳이 절벽이 아니라면
                    if(map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.offer(new Node(nx,ny,n.N+1));
                        continue;
                    }
                    if(map[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        int N = (n.N / M) * M + M;
                        queue.offer(new Node(nx,ny, N));
                    }else {
                        visited[ny][nx] = true;
                        int M = map[ny][nx];
                        int N = (n.N/ M) * M + M;
                        queue.offer(new Node(nx, ny, N));
                    }*/

                }
            }
            System.out.println("#" + t + " " + res);
        }

    }


    static class Node {
        int x;
        int y;
        int isAble;
        int N;

        public Node(int x, int y, int isAble ,int n) {
            this.x = x;
            this.y = y;
            this.isAble = isAble;
            this.N = n;
        }
    }
}
