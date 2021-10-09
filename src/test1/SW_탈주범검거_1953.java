package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_탈주범검거_1953 {
    static int N,M,R,C,L;
    static int cnt;
    static int map[][];
    static boolean visit[][];
    static Queue<Node> queue = new LinkedList<Node>();
    static int dx[] = { 0,0,-1, 1}; // 상 하 좌 우
    static int dy[] = {-1,1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visit = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            cnt = 0;
            Node node = new Node(C,R,1);
            queue.offer(node);
            visit[R][C] = true;

            while(!queue.isEmpty()) {
                Node n = queue.poll();

                cnt++;
                if(map[n.y][n.x] == 1) {
                    for(int i=0; i<4; i++) {
                        int nx = n.x + dx[i];
                        int ny = n.y + dy[i];
                        if(nx<0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] || map[ny][nx] == 0) continue;
                        if(n.dist >= L) continue;

                        if(i == 0) {
                            if(map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7) continue;
                        }
                        if(i == 1) {
                            if(map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6) continue;
                        }
                        if(i == 2) {
                            if(map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7) continue;
                        }
                        if(i == 3) {
                            if(map[ny][nx] == 2 || map[ny][nx] ==4 || map[ny][nx] == 5) continue;
                        }

                        Node nnode = new Node(nx,ny,n.dist+1);
                        queue.offer(nnode);
                        visit[ny][nx] = true;

                    }


                }else if(map[n.y][n.x] == 2) {
                    for(int i=0; i<2; i++) {
                        int nx = n.x + dx[i];
                        int ny = n.y + dy[i];
                        if(nx<0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] || map[ny][nx] == 0) continue;
                        if(n.dist >= L) continue;

                        if(i ==0) {
                            if(map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7) continue;
                        }

                        if(i == 1) {
                            if(map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6) continue;
                        }


                        Node nnode = new Node(nx,ny,n.dist+1);
                        queue.offer(nnode);
                        visit[ny][nx] = true;
                    }
                }else if(map[n.y][n.x] == 3) {
                    for(int i=2; i<4; i++) {
                        int nx = n.x + dx[i];
                        int ny = n.y + dy[i];
                        if(nx<0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] || map[ny][nx] == 0) continue;
                        if(n.dist >= L) continue;

                        if(i == 2) {
                            if(map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7) continue;
                        }
                        if(i == 3) {
                            if(map[ny][nx] == 2 || map[ny][nx] ==4 || map[ny][nx] == 5) continue;
                        }
                        Node nnode = new Node(nx,ny,n.dist+1);
                        queue.offer(nnode);
                        visit[ny][nx] = true;
                    }
                }else if(map[n.y][n.x] == 4) {
                    for(int i=0; i<4; i=i+3) {
                        int nx = n.x + dx[i];
                        int ny = n.y + dy[i];
                        if(nx<0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] || map[ny][nx] == 0) continue;
                        if(n.dist >= L) continue;
                        if(i == 0) {
                            if(map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7) continue;
                        }
                        if(i == 3) {
                            if(map[ny][nx] == 2 || map[ny][nx] ==4 || map[ny][nx] == 5) continue;
                        }
                        Node nnode = new Node(nx,ny,n.dist+1);
                        queue.offer(nnode);
                        visit[ny][nx] = true;
                    }
                }else if(map[n.y][n.x] == 5) {
                    for(int i=1; i<4; i=i+2) {
                        int nx = n.x + dx[i];
                        int ny = n.y + dy[i];
                        if(nx<0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] || map[ny][nx] == 0) continue;
                        if(n.dist >= L) continue;
                        if(i == 1) {
                            if(map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6) continue;
                        }
                        if(i == 3) {
                            if(map[ny][nx] == 2 || map[ny][nx] ==4 || map[ny][nx] == 5) continue;
                        }
                        Node nnode = new Node(nx,ny,n.dist+1);
                        queue.offer(nnode);
                        visit[ny][nx] = true;
                    }
                }else if(map[n.y][n.x] == 6) {
                    for(int i=1; i<3; i=i+1) {
                        int nx = n.x + dx[i];
                        int ny = n.y + dy[i];
                        if(nx<0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] || map[ny][nx] == 0) continue;
                        if(n.dist >= L) continue;
                        if(i == 1) {
                            if(map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6) continue;
                        }
                        if(i == 2) {
                            if(map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7) continue;
                        }
                        Node nnode = new Node(nx,ny,n.dist+1);
                        queue.offer(nnode);
                        visit[ny][nx] = true;
                    }
                }else if(map[n.y][n.x] == 7) {
                    for(int i=0; i<3; i=i+2) {
                        int nx = n.x + dx[i];
                        int ny = n.y + dy[i];
                        if(nx<0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] || map[ny][nx] == 0) continue;
                        if(n.dist >= L) continue;
                        if(i == 0) {
                            if(map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7) continue;
                        }
                        if(i == 2) {
                            if(map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7) continue;
                        }
                        Node nnode = new Node(nx,ny,n.dist+1);
                        queue.offer(nnode);
                        visit[ny][nx] = true;
                    }
                }

            }
            System.out.println("#" + t + " " +cnt);
        }
    }


    static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
