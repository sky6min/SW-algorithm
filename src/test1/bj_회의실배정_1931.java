package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_회의실배정_1931 {

    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Node node = new Node(start, end);
            pq.add(node);
        }

        int res = 0;

        int start = 0;
        int end = 0;
        Node n = pq.poll();
        start = n.start;
        end = n.end;
        res++;

        while(!pq.isEmpty()) {
            Node node = pq.poll();


            if(node.start >= end) {
                res++;
                start = node.start;
                end = node.end;
            }

        }
        System.out.println(res);
    }


    static class Node implements Comparable<Node> {

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int start;
        int end;

        @Override
        public int compareTo(Node o) {
            if(this.end == o.end) {
                if(this.start < o.start) {
                    return -1;
                }else {
                    return 1;
                }
            }
            if(this.end < o.end) {
                return -1;
            }else {
                return 1;
            }
        }
    }
}
