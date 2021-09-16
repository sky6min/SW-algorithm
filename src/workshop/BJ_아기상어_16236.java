package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_아기상어_16236 {

    static int map[][];
    static int[] dy = { 1, 0, -1,  0 };  // 하 우 상 좌
    static int[] dx = { 0, 1,  0, -1 };

    static Queue<Node> queue = new LinkedList<Node>();

    static int N, sx, sy, sharkSize, resTime;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = j;
                    sy = i;
                }
            }
        }
        sharkSize = 2;
        int foodCnt = 0;
        resTime = 0;

        while(true) {

            ArrayList<Node> al = new ArrayList<Node>();
            // 현재 상태에서 bfs로 탐색할 수 있는 노드들 탐색. + Arraylist에 유망한 먹이들 저장.
            bfs(al,sy,sx);

            // Arraylist가 비었으면 탈출
            if(al.isEmpty()) break;

            Collections.sort(al);
            // Arraylist에서 인덱스 0값을 받아옴. sx, sy resTime, sharkSize, foodcnt 갱신
            map[sy][sx] = 0;
            sx = al.get(0).x;
            sy = al.get(0).y;

            map[sy][sx] = 0;
            resTime += al.get(0).dist;

            foodCnt += 1;


            if(foodCnt == sharkSize) {
                foodCnt = 0;
                sharkSize += 1;
            }


        }

        System.out.println(resTime);
    }

    static void bfs(ArrayList<Node> al, int sy, int sx) {
        Node n = new Node(sy, sx, map[sy][sx], 0);
        queue.offer(n);
        boolean visited[][] = new boolean[N][N];
        visited[sy][sx] = true;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i=0; i<4; i++ ) {
                int rx = node.x + dx[i];
                int ry = node.y + dy[i];

                if(rx >= N || ry >= N || rx<0 || ry<0 || visited[ry][rx] || map[ry][rx] > sharkSize) continue;

                if(map[ry][rx] < sharkSize && map[ry][rx] != 0 && map[ry][rx] != 9) {
                    al.add(new Node(ry,rx,map[ry][rx], node.dist+1));

                }
                queue.offer(new Node(ry,rx,map[ry][rx], node.dist+1));
                visited[ry][rx] = true;


            }


        }

    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int size;
        int dist;


        public Node(int y, int x, int size, int dist) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.dist = dist;

        }

        @Override
        public int compareTo(Node o) {
            if(this.dist == o.dist) {

                if (this.y == o.y) {
                    return this.x - o.x;
                }
                return this.y - o.y;

            }
            return this.dist - o.dist;
        }
    }


}
