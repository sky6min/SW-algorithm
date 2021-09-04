package workshop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// N, M 이 충분히 작다
// 각각의 cctv의 감시 내용이 적용된 뒤에 다른 cctv 의 내용이 더해저야 한다.
public class bj_감시_15683 {

    static int N, M, min;
    static int[][] map;
    static ArrayList<Cam> list = new ArrayList<Cam>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if( n >= 1 && n <= 5 )	list.add(new Cam(i, j, n));
            }
        }
        min = Integer.MAX_VALUE;
        dfs(0, map);
        System.out.println(min);
    }

    static void dfs(int idx, int[][] parent) {
        // 기저 조건
        if( idx == list.size() ) {
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0 ; j < M; j++) {
                    if(parent[i][j] == 0) {
                        cnt++;
                    }
                }
            }

            min = Math.min(min, cnt);
            return;
        }


        Cam c = list.get(idx);

        switch(c.n) {
            case 1 :
                for (int d = 0; d < 4; d++) {
                    int[][] child = copyMap(parent);
                    watch(c.y, c.x, d, child);
                    dfs(idx + 1, child);
                }
                break;
            case 2 :
                for (int d = 0; d < 2; d++) {
                    int[][] child = copyMap(parent);
                    watch(c.y, c.x, d, child); 	// 상,하
                    watch(c.y, c.x, d+2, child); // 좌, 우
                    dfs(idx + 1, child);
                }
                break;
            case 3 :
                for (int d = 0; d < 4; d++) {
                    int[][] child = copyMap(parent);
                    // 2개 연속
                    watch(c.y, c.x, d, child);
                    watch(c.y, c.x, (d+1) % 4, child);
                    dfs(idx + 1, child);
                }
                break;
            case 4 :
                for (int d = 0; d < 4; d++) {
                    int[][] child = copyMap(parent);
                    // 3개 연속
                    watch(c.y, c.x, d, child);
                    watch(c.y, c.x, (d+1) % 4, child);
                    watch(c.y, c.x, (d+2) % 4, child);
                    dfs(idx + 1, child);
                }
                break;
            case 5 :
                for (int d = 0; d < 4; d++) {
                    int[][] child = copyMap(parent);
                    // 4개
                    watch(c.y, c.x, 0, child);
                    watch(c.y, c.x, 1, child);
                    watch(c.y, c.x, 2, child);
                    watch(c.y, c.x, 3, child);
                    dfs(idx + 1, child);
                }
                break;
        }
    }

    static void watch(int y, int x, int dir, int[][] last) {
//		dir 0 : 좌, 1: 상, 2 : 우, 3 : 하  => 한방향으로 번호 나열
        switch(dir) {
            case 0 : //좌
                for(int i = x; i >= 0; i--) {
                    if(last[y][i] == 6) break;
                    last[y][i] = 9;

                }
                break;
            case 1 :  //상
                for(int i = y; i >= 0; i--) {
                    if(last[i][x] == 6) break;
                    last[i][x] = 9;
                }
                break;
            case 2 : //우
                for(int i = x; i < M; i++) {
                    if(last[y][i] == 6) break;
                    last[y][i] = 9;
                }
                break;
            case 3 : //하
                for(int i = y; i < N; i++) {
                    if(last[i][x] == 6) break;
                    last[i][x] = 9;
                }
                break;
        }
    }

    static int[][] copyMap(int[][] origin){
        int[][] copy = new int[N][M];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }
    static class Cam {
        int y; int x; int n;

        public Cam(int y, int x, int n) {
            this.y = y; this.x = x; this.n = n;
        }
    }
}