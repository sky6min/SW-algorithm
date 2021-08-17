import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class test_subo {

    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    static Queue<Node> queue = new LinkedList<>();
    static Node[] ary;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입출력 구현
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            priorityQueue.clear();
            queue.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int tgt = Integer.parseInt(st.nextToken());
            int count = 1;
            ary = new Node[N];
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int n=0; n<N; n++) {
                int idx = n;
                int weight = Integer.parseInt(st2.nextToken());
                ary[n] = new Node(idx, weight);
                priorityQueue.offer(ary[n]);
                queue.offer(ary[n]);
            }

            // 알고리즘 구현
            while(true) {
                Node a = queue.poll();
                Node b = priorityQueue.peek();
                if(a.weight == b.weight) {
                    if(a.idx == tgt) {
                        break;
                    }
                    count++;
                    priorityQueue.poll();
                    continue;
                }
                queue.offer(a);
            }

            System.out.println(count);
        }
    }

    static class Node implements Comparable<Node> {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }
}
