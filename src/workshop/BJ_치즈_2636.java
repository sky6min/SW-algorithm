package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_치즈_2636 {

    static int map[][];
    static boolean cVisited[][];
    static boolean aVisited[][];
    static int dx[] = {-1,0,1,0};    // 좌 상 우 하
    static int dy[] = {0,-1,0,1};    // 좌 상 우 하
    static int R,C, cnt;
    // 탐색 : 0 or 1 의 유무
    //
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        cVisited = new boolean[R][C];
        aVisited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {

            for (int i = 0; i < R; i++) {

                for (int j = 0; j < C; j++) {
                    if (aVisited[i][j]) continue;
                    dfs(0, 0);
                }

            }
        }

    }

    static void dfs(int i, int j) {


        for(int d=0; d<4; d++) {
            int rx = j + dx[d];
            int ry = i + dy[d];

            if( rx >=0 && rx< C && ry >=0 && ry<R && map[ry][rx] == 1) {
                cVisited[ry][rx] = true;
                return;
            }

            if( rx >=0 && rx< C && ry >=0 && ry<R && map[ry][rx] == 0) {
                aVisited[ry][rx] = true;
                dfs(ry, rx);
            }

        }


    }
}
