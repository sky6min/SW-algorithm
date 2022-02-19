package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_말되원_1600 {
    static int H, W, K;
    static int dx[] = {1, 0, -1, 0};  // 우 하 좌 상
    static int dy[] = {0, 1, 0, -1};

    static int hx[] = {1,2,2,1,-1,-2,-2,-1};  // 우상, 우하, 좌하, 좌상
    static int hy[] = {2,1,-1,-2,-2,-1,1,2};

    static int map[][];
    static boolean visited[][][];
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0,0, K, 0);
        int res = ( min == Integer.MAX_VALUE) ? -1 : min;
        System.out.println(res);
    }

    static void dfs(int x, int y, int k, int cnt) {

        // if x,y 끝에 도달 하면 return;
        if(x == W-1 && y == H-1) {
            min = Math.min(min, cnt);
            return;
        }
        // 개 움직임
        for(int i=0; i<4; i++) {
            int rx = x + dx[i];
            int ry = y + dy[i];
            if(rx < 0 || ry < 0 || rx >= W || ry >= H || map[ry][rx] == 1 || visited[ry][rx][k]) {
                continue;
            }
            visited[ry][rx][k] = true;
            dfs(rx,ry,k,cnt+1);
            visited[ry][rx][k] = false;
        }

        // if k>0이면 말 움직임
        if(k > 0) {
            for(int i=0; i<8; i++) {
                int rx = x + hx[i];
                int ry = y + hy[i];
                if(rx < 0 || ry < 0 || rx >= W || ry >= H || map[ry][rx] == 1 || visited[ry][rx][k-1]) {
                    continue;
                }
                visited[ry][rx][k-1] = true;
                dfs(rx,ry,k-1,cnt+1);
                visited[ry][rx][k-1] = false;
            }
        }
    }
}
