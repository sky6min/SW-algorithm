package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_요세푸르_1158 {

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder output = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        queue.clear();
        for(int n=1; n<=N; n++) {
            queue.offer(n);
        }

        output.append("<");
        while(!queue.isEmpty()) {
            for(int i=0; i<K-1; i++) {
                int a = queue.poll();
                queue.offer(a);
            }
            int b = queue.poll();

            output.append(b+", ");
        }
        output.deleteCharAt(output.length()-2);
        output.deleteCharAt(output.length()-1);
        output.append(">");
        System.out.println(output);
    }
}
