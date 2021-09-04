package workshop;

import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_서로소집합_3289 {

    static int N, M;
    static int node1, node2, order;
    static int parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parent = new int[N+1];

            make();
            for(int m=0; m<M; m++) {
                st = new StringTokenizer(br.readLine());
                order = Integer.parseInt(st.nextToken());
                node1 = Integer.parseInt(st.nextToken());
                node2 = Integer.parseInt(st.nextToken());

                if(union(node1, node2, order)) {
                    if(order == 1) {
                        sb.append("1");
                    }
                }else {
                    if(order == 1) {
                        sb.append("0");
                    }
                }
            }
            System.out.print("#" + t + " ");
            System.out.println(sb.toString());
        }
    }

    static void make() {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

    }

    static int find(int a)  {
        if(a == parent[a]) return a;

        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b, int order) {
        int aParent = find(a);
        int bParent = find(b);

        if(aParent == bParent) return true;

        if(order == 0) {
            parent[bParent] = aParent;
        }
        return false;

    }
}
