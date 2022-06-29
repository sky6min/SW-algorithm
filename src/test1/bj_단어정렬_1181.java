package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;

public class bj_단어정렬_1181 {

    public static void main(String[] args) throws Exception {
        HashSet<String> set = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }

        set.forEach(item -> {
            Node node = new Node();
            node.val = item;
            pq.add(node);
        });

        while(!pq.isEmpty()) {
            System.out.println(pq.poll().val);
        }
    }

    static class Node implements Comparable<Node> {

        String val;

        @Override
        public int compareTo(Node o) {
            if(this.val.length() < o.val.length()) {
                return -1;
            }else if(this.val.length() == o.val.length()) {
                if(this.val.compareTo(o.val) > 0) {
                    return 1;
                }else {
                    return -1;
                }
            }else {
                return 1;
            }


        }
    }
}
