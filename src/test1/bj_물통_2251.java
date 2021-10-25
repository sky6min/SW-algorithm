package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_물통_2251 {

    static Queue<Node> queue = new LinkedList<Node>();
    static boolean visited[][][] = new boolean[3][3][201];

    static int src[] = new int[3];
    static ArrayList<Integer> al = new ArrayList<>();

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
        mount[2] = src[2];
        Node node = new Node(2, mount);
        al.add(src[2]);
        queue.offer(node);


        // 해당 지점의 량 처리

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            // cm -> am  cm의 물 양이 더 많은 경우
            for(int i=0; i<3; i++) {
                if(n.i == i) continue;
                if(visited[n.i][i][src[i]-n.mount[i]]) continue;
                visited[n.i][i][src[i]-n.mount[i]] = true;
                int mt[] = new int[3];
                mt[n.i] = n.mount[n.i] - (src[i] - n.mount[i]);  // from 여기 공식 잘못됨  클 경우랑 작을 경우 나눠야함
                mt[i] = src[i];  // to
                queue.offer(new Node(i, mt));
                if(mt[0] == 0) {
                    al.add(mt[2]);
                }
            }


        }
        for(int i=0; i<al.size(); i++) {
            System.out.print(al.get(i) + " ");
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
