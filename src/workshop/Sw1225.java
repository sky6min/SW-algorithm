package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw1225 {


    public static void main(String[] args) throws Exception {
        Queue<Integer> q = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            q.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            int cur = 1;
            int cnt = 1;

            while (cur != 0) {
                cur = q.poll();

                if (cnt == 6) cnt = 1;

                cur = cur - cnt;
                if (cur < 0) cur = 0;

                q.add(cur);
                cnt++;
            }

            System.out.print("#" + t + " ");
            for (int i = 0; i < 8; i++) {
                System.out.print(q.poll() + " ");
            }
            System.out.println();
        }
    }
}
