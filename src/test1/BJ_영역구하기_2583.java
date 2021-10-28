package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_영역구하기_2583 {

    static int map[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = { 0,-1, 0, 1};
    static boolean visited[][];
    static int M, N, cnt, res;
    static ArrayList<Integer> al = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            int fromx = Integer.parseInt(st.nextToken()); // 0
            int fromy = Integer.parseInt(st.nextToken()); // 2
            int tox = Integer.parseInt(st.nextToken()); // 4
            int toy = Integer.parseInt(st.nextToken()); // 4

            for(int i=fromy; i<toy; i++) {
                for(int j=fromx; j<tox; j++) {
                    map[i][j] = 1;
                }
            }
        }

        for(int i=0; i<M; i++) {

            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 || visited[i][j]) continue;
                cnt = 0;
                res++;
                dfs(i,j);
                al.add(cnt);
            }

        }

        System.out.println(res);
        al.sort(Comparator.naturalOrder());
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) +" ");
        }
    }

    static void dfs(int y, int x) {
        cnt++;
        visited[y][x] = true;
        for(int i=0; i<4; i++) {
            int rx = x + dx[i];
            int ry = y + dy[i];
            if(rx<0 || rx >=N || ry<0 || ry>=M || visited[ry][rx] || map[ry][rx] == 1) continue;
            dfs(ry, rx);
        }

    }
}
