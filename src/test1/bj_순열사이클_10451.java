package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_순열사이클_10451 {

    static boolean visited[];
    static ArrayList<Integer> al[];
    static int src[][];
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            cnt = 0;
            int N = Integer.parseInt(br.readLine());
            visited = new boolean[N+1];
            al = new ArrayList[N+1];
            for(int i=0; i<=N; i++) {
                al[i] = new ArrayList<Integer>();
            }
            src = new int[2][N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                src[0][i] = i;
                src[1][i] = Integer.parseInt(st.nextToken());
            }

            // 알고리즘
            for(int i=1; i<=N; i++) {
                if(visited[i]) continue;
                dfs(i);
            }
            System.out.println(cnt);
        }

    }

    static void dfs(int i) {
        visited[src[0][i]] = true;
        if(visited[src[1][i]]) {
            cnt++;
            return;
        }
        dfs(src[1][i]);

    }

}
