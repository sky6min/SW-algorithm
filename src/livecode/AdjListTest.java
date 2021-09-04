package livecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjListTest {

    static class Node{
        int vertex;  // 인접정점 인덱스
        Node link;
        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", link=" + link +
                    '}';
        }
    }

    static int N;  // 정점 개수
    static Node[] adjList;  // 인정행렬 (가중치 없음)

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        adjList = new Node[N];
        int C = Integer.parseInt(in.readLine());
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to,adjList[from]); // adjList[0] = new Node(1, adjList[0])
            adjList[to] = new Node(from,adjList[to]);  // adjList[1] = new Node(0, adjList[1])
        }

        System.out.println("=========bfs================");
        bfs();
        System.out.println("=========dfs================");
        boolean[] visited = new boolean[N];
        dfs(0,visited);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[N];

        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println((char)(current+65));

            for (Node temp = adjList[current]; temp!=null; temp = temp.link) {
                if(!visited[temp.vertex]) // 방문여부, 인접정점은 체크안해도됨
                {
                    queue.offer(temp.vertex);
                    visited[temp.vertex] = true;
                }
            }
        }
    }

    private static void dfs(int current, boolean[] visited) {

        visited[current] = true;
        System.out.println((char)(current+65));
        for (Node temp = adjList[current]; temp!=null; temp = temp.link) {
            if(!visited[temp.vertex]) // 방문여부
            {
                dfs(temp.vertex, visited);
            }
        }

    }

}
