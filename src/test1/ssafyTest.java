package test1;

import workshop.BJ_녹색옷젤다_4485;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ssafyTest {

    static int bus[] = new int[4];
    static int N, V;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<Node> al[];
    static boolean visited[];
    static int dist[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bus[1] = Integer.parseInt(st.nextToken());
        bus[2] = Integer.parseInt(st.nextToken());
        bus[3] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[V];
        al = new ArrayList[V];
        dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0; i<V; i++) {
            al[i] = new ArrayList<>();
        }
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            al[from].add(new Node(to,cost));

        }

        Dijkstra();

        Node resDist[] = new Node[4];
        for(int i=0; i<4; i++) {
            resDist[i] = new Node();
        }
        for(int i=1; i<4; i++) {
            bus[i] += dist[i];
            resDist[i].n = i;
            resDist[i].cost = bus[i];
        }

        for(int i=0; i<V; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
        Arrays.sort(resDist);
        System.out.print(resDist[1].n + " " + resDist[1].cost);
    }
    private static void Dijkstra() {
        dist[0] = 0;
        pq.offer(new Node(0, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            visited[cur.n] = true;
            for(int i=0; i<al[cur.n].size(); i++) {
                Node next = al[cur.n].get(i);
                if(!visited[next.n]) {
                    pq.offer(next);
                }
                if(dist[next.n] > dist[cur.n] + next.cost) {
                    dist[next.n] = dist[cur.n] + next.cost;
                }
            }

        }

    }

    static class Node implements Comparable<Node>{
        int n;
        int cost;

        public Node() {
        }

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
