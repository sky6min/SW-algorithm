package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw1861_Ans {

    static int[][] map;
    static int T, N;
    static int NO, COUNT;  // 방 번호, 카운트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            NO = 0;
            COUNT = 1;

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j< N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                }
            }

            //순회
            for(int i=0; i< N; i++) {
                for(int j=0; j< N; j++) {
                    dfs(i,j,map[i][j], 1);
                }
            }
            System.out.println("#" + t +" " + NO + " " + COUNT);
        }
    }

    static int[] dy = { -1, 1, 0, 0};
    static int[] dx = { 0, 0, -1, 1};

    static void dfs(int y, int x, int no, int cnt) {

        // 방문 => 자격이 있다.
        if(cnt > COUNT) {
            COUNT = cnt;
            NO = no;
        }else if(cnt == COUNT) {
            NO = Math.min(NO, no);
        }
        //기저조건
        // 4 방향 갈 수 있는 지 없는 지 판단
        //탐색 +1 다시 갈수있다.
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if( ny<0 || nx <0 || ny >= N || nx >= N || map[ny][nx] != map[y][x]+1) continue;
            dfs(ny, nx, no, cnt+1);
        }


    }

}
