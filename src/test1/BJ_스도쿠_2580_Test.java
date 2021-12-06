package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_스도쿠_2580_Test {

    static int map[][];
    static ArrayList<Point> zero;
    static boolean complete = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        zero = new ArrayList<Point>();
        map = new int[9][9];

        for(int i=0; i<9; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<9; j++) {
                map[i][j] = line[j] - '0';
                if(map[i][j] == 0) zero.add(new Point(i,j));
            }
        }

        dfs(0);
    }

    static void dfs(int idx) {
        // 기저조건
        if(complete ) return;

        if( idx == zero.size()) {
            // complete code
            complete = true;
            for(int i=0; i<9; i++ ) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            return;
        }

        Point p = zero.get(idx);
        int y = p.y;
        int x = p.x;

        // 가지치기코드
        // 이미 y, x에 사용할 수 없는 숫자 계산 행/열/3x3 사용된 숫자제외
        boolean[] visit = new boolean[10]; // 0 dummy


        // 행
        for(int i=0; i<9; i++) {
            if(map[y][i] != 0) visit[map[y][i]] = true;
        }

        // 열
        for(int i=0; i<9; i++) {
            if(map[i][x] != 0) visit[map[i][x]] = true;
        }
        // 3x3
        int ny = (y/3) * 3;
        int nx = (x/3) * 3;

        for(int i = ny; i< ny+3; i++) {
            for(int j = nx; j < nx+3; j++) {
                if(map[i][j] != 0) visit[map[i][j]] = true;
            }
        }

        //재귀
        for(int i=1; i<=9; i++) { // 2,5,6,7
            if(!visit[i]) {
                map[y][x] = i; // 2
                dfs(idx+1);
                map[y][x] = 0;
            }

        }

    }

    static class Point{
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
