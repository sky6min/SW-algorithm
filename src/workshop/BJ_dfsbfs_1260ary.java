package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_dfsbfs_1260ary {

    static int N,M,V;
    static boolean[][] graph;
    static StringBuilder ans = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][N+1]; // 0 dummy => visit

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            // 양쪽 모두 연결
            graph[n1][n2] = true;
            graph[n2][n1] = true;
        }

        // 탐색 - dfs
        graph[V][0] = true; // visit[V] = true
        dfs(V);  // 시작 정점 V

        System.out.println(ans.toString());
        // 방문 초기화
        for(int i=1; i< N; i++) {
            graph[i][0] = false;
        }
        ans.setCharAt(ans.length()-1, '\n');
        //시작코드
        bfs();
        System.out.println(ans.substring(0, ans.length()-1));
    }

    static void dfs(int num) {
        // 할일
        ans.append(num).append(" ");

        for (int i = 1; i <= N; i++) {
            // num 정점이 방문할 수 있는 정점1
            if( graph[num][i] && ! graph[i][0]) {  // num 정점 --> i 정점
                graph[i][0] = true;
                dfs(i);
            }
        }
    }

    static void bfs() {
        //시작 코드
        graph[V][0] = true;
        queue.offer(V);

        while( ! queue.isEmpty()) {

            int num = queue.poll();

            ans.append(num).append(" ");

            for (int i = 1; i <= N; i++) {
                // num 정점이 방문할 수 있는 정점1
                if( graph[num][i] && ! graph[i][0]) {  // num 정점 --> i 정점
                    graph[i][0] = true;
                    queue.offer(i);
                }
            }
        }
    }
}




