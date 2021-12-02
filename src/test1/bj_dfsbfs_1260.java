package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_dfsbfs_1260 {
    static int N, M, V;
    static boolean map[][];
    static boolean visited[];
    static boolean visited2[];
    static Queue<Integer> queue = new LinkedList<>();

    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        map = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        visited2 = new boolean[N+1];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = true;
            map[to][from] = true;
        }

        dfs(V);
        System.out.println(sb.toString());

        bfs(V);

        System.out.println(sb2.toString());
    }

    static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur + " ");
        for(int i=0; i<N+1; i++) {
            if(map[cur][i]) {
                int next = i;
                if(visited[next]) continue;
                dfs(next);
            }
        }

    }

    static void bfs(int start) {
        queue.offer(start);
        visited2[start] = true;
        sb2.append(start+ " ");
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i=0; i<N+1; i++) {
                if(map[cur][i]) {
                    if(visited2[i]) continue;
                    visited2[i] = true;
                    sb2.append(i + " ");
                    queue.offer(i);
                }
            }
        }
    }
}
