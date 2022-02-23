package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_결혼식_5567 {

    static Queue<Node> queue = new LinkedList<Node>();
    static ArrayList<Node> al[];
    static boolean visited[];
    static int res;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        al = new ArrayList[N+1];
        visited = new boolean[N+1];
        res = -1;

        for (int i = 0; i < N + 1; i++) {
            al[i] = new ArrayList<Node>();
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            al[to].add(new Node(0,from));
            al[from].add(new Node(0, to));
        }

        queue.add(new Node(0, 1));
        visited[1] = true;
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.depth <= 2) res++;

            for(int i=0; i<al[node.val].size(); i++) {
                if(visited[al[node.val].get(i).val]) continue;
                visited[al[node.val].get(i).val] = true;
                Node n = al[node.val].get(i);
                n.depth = node.depth + 1;
                queue.add(n);
            }

        }

        System.out.println(res);
    }


    static class Node {
        int depth;
        int val;

        Node(int depth, int val) { this.depth = depth; this.val = val;}


    }
}
