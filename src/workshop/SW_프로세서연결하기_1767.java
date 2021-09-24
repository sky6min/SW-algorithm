package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_프로세서연결하기_1767 {

    static int N, M, min;
    static int[][] map;

    //dfs - 정점
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = { 0, 0,-1, 1};

    // 정점
    static int V;

    // 쿠르스칼 - Edge
    static PriorityQueue<Edge> pqueue = new PriorityQueue<Edge>( (e1,e2) -> e1.cost - e2.cost);
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken())*(-1);
            }
        }

        // 정점
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == -1 && ! visit[i][j]) {
                    dfs(i,j,num);
                    num++;
                }

            }
        }
        V = num - 1;   // 정점의 수

        parent = new int[V+1];     // 0 dummy
        makeSet(V);

        // 간선
        hr();
        vr();

        // 쿠르스칼
        int cnt = 0;
        while(!pqueue.isEmpty()) {
            Edge e = pqueue.poll();
            if(findSet(e.v1) == findSet(e.v2)) continue;

            union(e.v1, e.v2);
            min += e.cost;
            cnt++;
            if(cnt == V-1) break;
        }

        if( cnt != V-1) min = -1;
        System.out.println(min);

    }

    static void addEdge(int v1, int v2, int cost) {
        Iterator<Edge> itr = pqueue.iterator();
        boolean same = false;
        while(itr.hasNext()) {
            Edge e = itr.next();
            if( e.v1 == v1 && e.v2 == v2) {
                same = true;
                if(e.cost > cost) e.cost = cost;
            }
        }

        if(!same) pqueue.offer(new Edge(v1,v2,cost));
    }

    static void hr() {

        for (int i = 0; i < N; i++) {
            int prev = 0;
            int curr = 0;
            int v1 = 0;
            int v2 = 0;
            int cost = 0;
            for (int j = 0; j < M; j++) {
                curr = map[i][j];
                if( prev == 0 && curr != 0 ) { // 0 (바다) => 0 아님 (섬)

                    if( v1 == 0 ) v1 = curr;  // 시작 섬
                    else {
                        // edge 발생
                        v2 = curr;
                        System.out.println(v1 + "---" + v2 + " : " + cost );
                        if( cost > 1 ) {
                            // addEdge 에서 동일 다리가 있으면 최소값으로 갱신하고 없으면 넣는다.
                            addEdge(v1, v2, cost);
                            //addEdge(v2, v1, cost); // 쿠르스칼은 한쪽 만 해도 해결
                        }
                        v1 = v2;
                        v2 = 0;
                        cost = 0;
                    }
                }else if( v1 != 0 && curr == 0 ) {
                    cost++;
                }

                prev = curr;
            }
        }
    }

    static void vr() {

        for (int i = 0; i < M; i++) {
            int prev = 0;
            int curr = 0;
            int v1 = 0;
            int v2 = 0;
            int cost = 0;
            for (int j = 0; j < N; j++) {
                curr = map[j][i];
                if( prev == 0 && curr != 0 ) {
                    if( v1 == 0 ) v1 = curr;
                    else {
                        // edge 발생
                        v2 = curr;
                        System.out.println(v1 + "---" + v2 + " : " + cost );
                        if( cost > 1 ) {
                            addEdge(v1, v2, cost);
                            //addEdge(v2, v1, cost); // 쿠르스칼은 한쪽 만 해도 해결
                        }
                        v1 = v2;
                        v2 = 0;
                        cost = 0;
                    }
                }else if( v1 != 0 && curr == 0 ) {
                    cost++;
                }

                prev = curr;
            }
        }
    }


    static void dfs(int y, int x, int num) {
        visit[y][x] = true;
        map[y][x] = num;
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if( ny<0 || nx<0 || ny>=N || nx >= M || visit[ny][nx]) continue;
            if(map[ny][nx] == -1) dfs(ny, nx, num);
        }

    }

    static void makeSet(int num) {
        for (int i = 1; i <= num; i++) {
            parent[i] = i;  // 정점
        }
    }

    static int findSet(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = findSet(parent[x]);
    }

    static void union(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);
        if( pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
    }

    // 간선
    static class Edge{
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }
}
