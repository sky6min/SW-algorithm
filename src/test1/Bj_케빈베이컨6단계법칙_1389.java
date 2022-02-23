package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_케빈베이컨6단계법칙_1389 {
    static Queue<Node> queue = new LinkedList<Node>();
    static ArrayList<Node> al[];
    public static void main(String[] args) throws Exception {
        int N, M;
        int min = Integer.MAX_VALUE;
        int kevin = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        al = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            al[i] = new ArrayList<Node>();
        }
        for (int i = 0; i <M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            Node n1 = new Node(0,to);
            al[from].add(n1);
            Node n2 = new Node(0,from);
            al[to].add(n2);
        }

        // bfs 알고리즘
        for(int i=1; i<N+1; i++) {
            boolean visited[] = new boolean[N+1];
            int res = 0;
            queue.offer(new Node(0, i));
            while(!queue.isEmpty()) {
                Node node = queue.poll();
                visited[node.cur] = true;
                res += node.depth;  // 현재값 처리
                for(int j=0; j<al[node.cur].size(); j++) {   // 다음값 처리
                    if(visited[al[node.cur].get(j).cur]) continue;
                    Node newNode = new Node(node.depth+1, al[node.cur].get(j).cur);
                    queue.offer(newNode);
                }
            }

            if(min != Math.min(res, min)) {
                min = res;
                kevin = i;
            }
        }


        System.out.println(kevin);
    }

    static class Node {
        Node(int depth, int cur) {this.depth = depth; this.cur = cur;}
        int depth;
        int cur;
    }
}
