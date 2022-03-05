package test1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class PG_오픈채팅방_3 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] example = {"111100000", "000010011", "111100011", "111110011", "111100011", "111100010", "111100000"};
        sol.solution(7,9,4,example);
    }

    static class Solution {
        int H;
        int W;
        int N;
        int ncnt;
        int res = 0;
        boolean visited[][][];
        int dx[] = {1, -1, 0, 0, 1, -1, -1, 1};         // 좌 우 상 하 우대각상 좌대각하 좌대각상 우대각하
        int dy[] = { 0, 0,-1, 1,-1,  1, -1, 1};         // 좌 우 상 하 우대각상 좌대각하 좌대각상 우대각하
        char[][] map;
        public int solution(int h, int w, int n, String[] board) {
            H = h;
            W = w;
            N = n;
            visited = new boolean[H][W][4];  // 0 가로 1 세로 2 우대각 3 좌대각
            map = new char[H][W];
            for(int i=0; i<H; i++) {
                map[i] = board[i].toCharArray();
            }

            for(int i=0; i<H; i++) {
                for(int j=0 ;j<W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {

                    if(!visited[i][j][0] && map[i][j] == '1') {
                        ncnt = 0;
                        // 현재 위치에서 우로
                        dfs(i,j, 0);
                        // 현재 위치에서 좌로
                        dfs(i,j, 1);
                        if(ncnt-1 == n) {// n목 계산
                            System.out.println("가로");
                            System.out.println("가로 위치 : " + j + "세로 위치 : " + i);
                            res++;
                        }
                    }

                    if(!visited[i][j][1] && map[i][j] == '1') {
                        ncnt = 0;
                        // 현재 위치에서 상
                        // 현재 위치에서 하
                        dfs(i,j, 2);
                        dfs(i,j, 3);
                        if(ncnt-1 == n) {// n목 계산
                            System.out.println("세로");
                            System.out.println("가로 위치 : " + j + "세로 위치 : " + i);
                            res++;
                        }
                    }

                    if(!visited[i][j][2] && map[i][j] == '1') {
                        ncnt = 0;
                        dfs(i,j, 4);
                        dfs(i,j, 5);
                        if(ncnt-1 == n) {// n목 계산
                            System.out.println("가로 위치 : " + j + "세로 위치 : " + i);
                            res++;
                        }
                    }

                    if(!visited[i][j][3] && map[i][j] == '1') {
                        ncnt = 0;
                        dfs(i,j, 6);
                        dfs(i,j, 7);
                        if(ncnt-1 == n) {// n목 계산
                            System.out.println("가로 위치 : " + j + "세로 위치 : " + i);
                            res++;
                        }
                    }

                }
            }
            return res;
        }

        void dfs(int h, int w, int dir) {

            ncnt++;
            // 가로 visited
            if(dir == 0 || dir == 1) {
                visited[h][w][0] = true;
            }else if(dir == 2 || dir == 3) {
                visited[h][w][1] = true;
            }else if(dir == 4 || dir == 5 ) {
                visited[h][w][2] = true;
            }else if(dir == 6 || dir == 7) {
                visited[h][w][3] = true;
            }

            int rx = w + dx[dir];
            int ry = h + dy[dir];

            if(dir == 0 || dir == 1) {
                if(rx <0 || ry < 0 || rx >= W || ry >= H || visited[ry][rx][0] || map[ry][rx] == '0' ) return;
                dfs(ry,rx,dir);
            }else if(dir == 2 || dir == 3) {
                if(rx <0 || ry < 0 || rx >= W || ry >= H || visited[ry][rx][1] || map[ry][rx] == '0' ) return;
                dfs(ry,rx,dir);
            }else if(dir == 4 || dir == 5 ) {
                if(rx <0 || ry < 0 || rx >= W || ry >= H || visited[ry][rx][2] || map[ry][rx] == '0' ) return;
                dfs(ry,rx,dir);
            }else if(dir == 6 || dir == 7) {
                if(rx <0 || ry < 0 || rx >= W || ry >= H || visited[ry][rx][3] || map[ry][rx] == '0' ) return;
                dfs(ry,rx,dir);
            }

        }
    }
}
