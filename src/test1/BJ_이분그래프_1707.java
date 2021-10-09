package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_이분그래프_1707 {

    static Queue<Integer> queue = new LinkedList<Integer>();
    static ArrayList<Integer> al[];
    static int visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int res = 0;
            int from = 0;
            int to = 0;
            al = new ArrayList[V+1];
            visited = new int[V+1];
            for(int i=0; i<=V; i++) {
                al[i] = new ArrayList<Integer>();
            }

            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                al[from].add(to);
                al[to].add(from);
            }

            // bfs 알고리즘
            for(int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }

                while (!queue.isEmpty()) {
                    int val = queue.poll();
                    for (int j = 0; j < al[val].size(); j++) {
                        int n = al[val].get(j);
                        if (visited[val] == 1 && visited[n] == 0) {
                            visited[n] = 2;
                            queue.offer(n);
                        } else if (visited[val] == 2 && visited[n] == 0) {
                            visited[n] = 1;
                            queue.offer(n);
                        }

                        if (visited[val] == 1 && visited[n] == 1) {
                            res = 1;
                        } else if (visited[val] == 2 && visited[n] == 2) {
                            res = 1;
                        }
                    }

                }
            }
            System.out.println((res > 0) ? "NO" : "YES");
        }

    }
}
