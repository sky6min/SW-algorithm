package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_인내의도미노장인호석_20165 {

    static char visited[][];
    static int map[][];
    static int N, M, cnt;
    static int res;
    static int dx[] = new int[125];
    static int dy[] = new int[125];
    static int attack[][];
    static int defence[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dx['E'] = 1;
        dy['E'] = 0;
        dx['W'] = -1;
        dy['W'] = 0;
        dx['S'] = 0;
        dy['S'] = 1;
        dx['N'] = 0;
        dy['N'] = -1;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());
        attack = new int [cnt][3];
        defence = new int [cnt][2];
        map = new int[N+1][M+1];
        visited = new char[N+1][M+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        res = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                visited[i][j] = 'S';
            }
        }
        for(int i=0; i<cnt; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                attack[i][j] = Integer.parseInt(st.nextToken());
            }
            attack[i][2] = st.nextToken().charAt(0);

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                defence[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<cnt; i++) {
            // 공격
            int arow = attack[i][0];
            int acol = attack[i][1];
            int adir = attack[i][2];
            dfs(arow, acol,map[arow][acol], adir);  // 세로칸, 가로칸, 현재 크기,방향

            // 수비
            int drow = defence[i][0];
            int dcol = defence[i][1];
            visited[drow][dcol] = 'S';

        }

        // 출력부
        System.out.println(res);
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                System.out.printf("%c ",visited[i][j]);
            }
            System.out.println();
        }
    }

    static void dfs(int row, int col, int size ,int dir) {  // 세로칸, 가로칸, 방향

        // row, col 현재 위치에 대한 처리
        if(visited[row][col] == 'S') {
            res++;
        }
        visited[row][col] = 'F';

        // 다음위치 판단 (다음값으로 갈수 있는가에 대한 기저조건)
        if(row+dy[dir] > N || row+dy[dir] <= 0 || col+dx[dir] > M || col + dx[dir] <= 0) return;

        // 길이가 짧다 다음으로 못간다. (다음값으로 갈수 있는가에 대한 기저조건)
        if(size-1 == 0) {
            return;
        }

        // 교체조건 2 2 2-1 2 다음 위치를 (설정)해주는 처리
        if(size-1 < map[row+dy[dir]][col+dx[dir]] && visited[row+dy[dir]][col+dx[dir]] == 'S')   // 다음값이 현재값-1 보다 크면 다음값으로 교체
        {
            size = map[row+dy[dir]][col+dx[dir]];
            // 다음 dfs로 이동
            dfs(row+dy[dir], col+dx[dir], size, dir);
        }else{
            // 다음 dfs로 이동
            dfs(row+dy[dir], col+dx[dir], size-1, dir);
        }


    }
}
