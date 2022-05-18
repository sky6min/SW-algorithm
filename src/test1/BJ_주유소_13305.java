package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_주유소_13305 {

    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String cost[] = new String[N-1];
        String edge[] = new String[N-1];
        cost = br.readLine().split(" ");
        edge = br.readLine().split(" ");

        pq.offer(Long.parseLong(edge[0]));

        long res = 0;
        for (int i = 0; i < N - 1; i++) {
            long e = pq.peek();
            res += e * Long.parseLong(cost[i]);
            pq.offer(Long.parseLong(edge[i+1]));
        }

        System.out.println(res);

    }
}