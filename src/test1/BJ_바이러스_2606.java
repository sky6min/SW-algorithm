package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_바이러스_2606 {

    static ArrayList<Integer> al[];
    static boolean visited[];
    static int cnt = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        al = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=0; i<N+1; i++) {
            al[i] = new ArrayList<Integer>();
        }

        int C = Integer.parseInt(br.readLine());
        for(int i=0; i<C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            al[from].add(to);
            al[to].add(from);
        }

        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int num) {
        cnt++;
        visited[num] = true;
        for(int i=0; i<al[num].size(); i++) {
            if(visited[al[num].get(i)]) continue;
            dfs(al[num].get(i));
        }

    }
}
