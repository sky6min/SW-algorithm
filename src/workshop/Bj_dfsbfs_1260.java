package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_dfsbfs_1260 {

    static Node list[];
    static int N, M, V;
    static boolean visited[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new Node[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from] = new Node(to, list[from]);
            list[to] = new Node(from, list[to]);
        }

        dfs(V);

    }

    static void dfs(int v) {
        visited[v] = true;
        System.out.println(v);
        for(Node node = list[v]; node!=null; node = node.link ) {

            if(!visited[node.vertex]) {
                dfs(node.vertex);
            }
        }
    }

    static class Node{
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }
}
