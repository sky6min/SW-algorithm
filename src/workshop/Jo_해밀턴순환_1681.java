package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jo_해밀턴순환_1681 {

    static int map[][];
    static boolean visited[];
    static int N;
    static int tgt[];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        tgt = new int[N-1];
        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


//        for(int i=0; i<N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        visited[0] = true;
        dfs(0,0,0);
        System.out.println(min);
    }

    static void dfs(int start, int cost, int idx) {

        if(idx == N-1) {
            if(map[start][0] == 0) return;
            cost += map[start][0];
            min = Math.min(min, cost);
            return;
        }
        if(cost > min) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i] || map[start][i] == 0) continue;
            visited[i] = true;

            dfs(i, cost+map[start][i], idx+1);
            visited[i] = false;
        }

    }
}
