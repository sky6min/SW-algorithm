package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_contact_1238 {

    static boolean nodeList[][];
    static int cnt[];
    static int cur;
    static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            nodeList = new boolean[101][101];
            cnt = new int[101];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                nodeList[from][to] = true;
            }

            queue.offer(s);
            nodeList[s][0] = true;

            while (!queue.isEmpty()) {
                cur = queue.poll();

                for (int i = 1; i <= 100; i++) {
                    if (nodeList[cur][i] == true && nodeList[i][0] == false) {
                        queue.offer(i);
                        nodeList[i][0] = true;
                        cnt[i] = cnt[cur] + 1;
                    }
                }

            }

            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= 100; i++) {
                if (cnt[cur] == cnt[i]) {
                    max = Math.max(i, max);
                }

            }
            System.out.print("#" + t + " ");
            System.out.println(max);
        }
    }
}
