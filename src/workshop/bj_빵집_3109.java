package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_빵집_3109 {

    static char map[][];
    static boolean visited[][];
    static int R,C, COUNT1,COUNT2, flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        COUNT1 = 0;
        for(int i=0; i<R; i++) {
            flag = 0;
            search1(i,0);
        }
        for(int i=0; i<R; i++) {
            Arrays.fill(visited[i], false);
        }
        for(int i=R-1; i>=0; i--) {
            flag = 0;
            search2(i,0);
        }
        System.out.print(Math.max(COUNT1,COUNT2));
    }

    static void search1(int row,int col) {
        //기저조건


        if(col == C-1) {
            COUNT1++;
            return;
        }

        //알고리즘
        //우상
        visited[row][col] = true;
        if(row-1>=0 && map[row-1][col+1] != 'x' && !visited[row-1][col+1]) {
            search1(row-1,col+1);
            if(flag == 1) {
                visited[row][col] = false;
            }
            return;
        }

        //우
        if(map[row][col+1] != 'x' && !visited[row][col+1]) {
            search1(row,col+1);
            if(flag == 1) {
                visited[row][col] = false;
            }
            return;
        }

        //우하
        if(row+1<R && map[row+1][col+1] != 'x' && !visited[row+1][col+1]) {
            search1(row+1,col+1);
            if(flag == 1) {
                visited[row][col] = false;
            }
            return;
        }

        flag = 1;
    }

    static void search2(int row,int col) {
        //기저조건


        if(col == C-1) {
            COUNT2++;
            return;
        }

        //알고리즘
        visited[row][col] = true;
        //우하
        if(row+1<R && map[row+1][col+1] != 'x' && !visited[row+1][col+1]) {
            search2(row+1,col+1);
            if(flag == 1) {
                visited[row][col] = false;
            }
            return;
        }

        //우
        if(map[row][col+1] != 'x' && !visited[row][col+1]) {
            search2(row,col+1);
            if(flag == 1) {
                visited[row][col] = false;
            }
            return;
        }

        //우상

        if(row-1>=0 && map[row-1][col+1] != 'x' && !visited[row-1][col+1]) {
            search2(row-1,col+1);
            if(flag == 1) {
                visited[row][col] = false;
            }
            return;
        }

        flag = 1;
    }
}
