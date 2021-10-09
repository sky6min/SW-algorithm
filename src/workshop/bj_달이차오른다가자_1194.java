package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_달이차오른다가자_1194 {

    static char[][] map;
    static int N, M;
    static boolean visited[][][];

    static Queue<Node> queue = new LinkedList<Node>();
    static int min = Integer.MAX_VALUE;
    static int start[] = new int[2];
    static int end[][];
    static int cnt;

    static int dx[] = {0, 1, 0,-1};  // 하 우 상 좌
    static int dy[] = {1, 0,-1, 0};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cnt = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][7];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();

            for(int j=0; j<M; j++) {
                if(map[i][j] == '0') {
                    start[0] = i;   // y좌표
                    start[1] = j;   // x좌표
                }

                if(map[i][j] == '1') {
                    cnt += 1;
                }
            }
        }
        end = new int[cnt][2];
        int idx = 0;
        for(int i=0; i<N; i++) {


            for(int j=0; j<M; j++) {

                if(map[i][j] == '1') {

                    end[idx][0] = i;   // y좌표
                    end[idx][1] = j;   // x좌표
                    idx= idx + 1;
                }
            }
        }

        // 알고리즘
        Node node = new Node(start[1], start[0], 0);
        queue.offer(node);

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            visited[n.y][n.x][0] = true;

            for(int i=0; i<n.key.size(); i++) {
                switch(n.key.get(i)) {
                    case 'a': visited[n.y][n.x][1] = true; break;
                    case 'b': visited[n.y][n.x][2] = true; break;
                    case 'c': visited[n.y][n.x][3] = true; break;
                    case 'd': visited[n.y][n.x][4] = true; break;
                    case 'e': visited[n.y][n.x][5] = true; break;
                    case 'f': visited[n.y][n.x][6] = true; break;
                }

            }

            for(int i=0; i<4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if(n.key.isEmpty()) {
                    if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[ny][nx][0] || map[ny][nx] == '#' || map[ny][nx] == 'A'|| map[ny][nx] == 'B'|| map[ny][nx] == 'C'|| map[ny][nx] == 'D'|| map[ny][nx] == 'E'|| map[ny][nx] == 'F') continue;
                }else{
                    if (nx < 0 || ny < 0 || nx >= M || ny >= N || map[ny][nx] == '#') continue;
                    if(n.key.contains('a') && visited[ny][nx][1]) continue;
                    if(n.key.contains('b') && visited[ny][nx][2]) continue;
                    if(n.key.contains('c') && visited[ny][nx][3]) continue;
                    if(n.key.contains('d') && visited[ny][nx][4]) continue;
                    if(n.key.contains('e') && visited[ny][nx][5]) continue;
                    if(n.key.contains('f') && visited[ny][nx][6]) continue;
                    if (map[ny][nx] == 'A') {

                        if(!n.key.contains('a')) continue;
                    }
                    else if (map[ny][nx] == 'B') {

                        if(!n.key.contains('b')) continue;
                    }
                    else if (map[ny][nx] == 'C') {

                        if(!n.key.contains('c')) continue;
                    }
                    else if (map[ny][nx] == 'D') {

                        if(!n.key.contains('d')) continue;
                    }
                    else if (map[ny][nx] == 'E') {

                        if(!n.key.contains('e')) continue;
                    }
                    else if (map[ny][nx] == 'F') {

                        if(!n.key.contains('f')) continue;
                    }

                }
                Node nd = new Node(nx, ny, n.cnt+1);

                if(n.key.contains('a')) nd.key.add('a');
                if(n.key.contains('b')) nd.key.add('b');
                if(n.key.contains('c')) nd.key.add('c');
                if(n.key.contains('d')) nd.key.add('d');
                if(n.key.contains('e')) nd.key.add('e');
                if(n.key.contains('f')) nd.key.add('f');
                if(map[ny][nx] == 'a' || map[ny][nx] == 'b' || map[ny][nx] == 'c' || map[ny][nx] == 'd' || map[ny][nx] == 'e' || map[ny][nx] == 'f') {
                    nd.key.add(map[ny][nx]);
                }
                for(int a=0; a<cnt; a++) {
                    if(nd.x == end[a][1] && nd.y == end[a][0]) {
                        min = Math.min(min, nd.cnt);
                    }
                }

                queue.offer(nd);

            }



        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static class Node{
        int x;
        int y;
        int cnt;
        ArrayList<Character> key;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = new ArrayList<Character>();
        }
    }
}
