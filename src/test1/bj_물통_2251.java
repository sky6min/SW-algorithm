package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_물통_2251 {

    static Queue<Node> queue = new LinkedList<Node>();
    static boolean visited[][][] = new boolean[3][3][201];

    static int src[] = new int[3];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        src[0] = Integer.parseInt(st.nextToken());
        src[1] = Integer.parseInt(st.nextToken());
        src[2] = Integer.parseInt(st.nextToken());

        // 시작점
        int mount[] = new int[3];
        mount[0] = 0;
        mount[1] = 0;
        mount[2] = 10;
        Node node = new Node(2, mount);
        queue.offer(node);


        // 해당 지점의 량 처리

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            // cm -> am  cm의 물 양이 더 많은 경우
            for(int i=0; i<2; i++) {
                if(node.i == i) continue;
//                if()

            }

            // cm의 물 양이 더 적은 경우

            // cm -> bm cm의 물 양이 더 많은 경우
            // cm의 물 양이 더 적은 경우


        }
    }

    static class Node{
        int i;
        int mount[];

        public Node(int i, int mount[]) {
            this.i = i;
            this.mount = mount;
        }
    }
}
