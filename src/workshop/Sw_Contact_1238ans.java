package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_Contact_1238ans {

    static int L, S, maxNum, maxDepth;
    static boolean[][] graph;
    static boolean[] visit;  // 정점에 대한 방문
    static Queue<Vertex> queue = new LinkedList<Vertex>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            // 초기화
//            graph = new boolean[][]
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < L / 2; i++) {
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Vertex {
        int n;
        int d;

        public Vertex(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }
}
