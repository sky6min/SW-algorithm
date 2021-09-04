package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class bj_빵집_3109ans {

    static char[][] map;
    static int R, C, ans;
    // delta dy 만 : x계속 1증가

    static int[] dy = { -1, 0, 1}; // 상우, 우, 하우

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        //탐색(행 위쪽부터 아래로 가면서 가장 왼쪽 열 ) - 순회(dfs)
        for(int i=0; i< R; i++) {
            if(dfs(i,0) ) ans++;
        }
    }

    static boolean dfs(int i, int j) {

        int nx = j + 1;

        for (int d = 0; d < 3; d++) {
            int ny = i + dy[d];

            if(ny < 0 || ny >= R || map[ny][nx] == 'x') continue;
            //탐색? 끝?
            if(nx == C-1) return true;

            map[ny][nx] = 'x'; // visit

            if(dfs(ny, nx ) ) return true;
        }
        // 못가면
        return false;
    }
}
