package test1;


import java.util.*;

public class PG_행렬테두리회전하기 {


    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        int[][] queries = {{1,1,100,97}};
        solution(100,97,queries);
    }

    static int dx[] = {1,0,-1,0}; // 하 우 상 좌
    static int dy[] = {0,1,0,-1};

    static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        System.out.println(queries.length);
        int[][] map = new int[rows][columns];

        int val = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                map[i][j] = val++;
            }
        }

        // 쿼리 수만큼 돎.
        for(int i=0; i< queries.length; i++) {
            int left = queries[i][1]-1;
            int top = queries[i][0]-1;
            int right = queries[i][3]-1;
            int bottom = queries[i][2]-1;

            int min = Integer.MAX_VALUE;

            // 현재 위치
            int cx = left;
            int cy = top;

            int temp = map[cy][cx];
            // 아래로이동
            for(;cy<bottom; cy++) {
                map[cy][cx] = map[cy+1][cx];
                min = Math.min(min,map[cy][cx]);
            }

            // 왼쪽이동
            for(;cx<right; cx++) {
                map[cy][cx] = map[cy][cx+1];
                min = Math.min(min,map[cy][cx]);
            }

            // 위로이동
            for(;cy>top; cy--) {
                map[cy][cx] = map[cy-1][cx];
                min = Math.min(min,map[cy][cx]);
            }

            // 오른쪽이동
            for(;cx>left; cx--) {
                if(cx == left+1) {
                    map[cy][cx] = temp;
                    min = Math.min(min,map[cy][cx]);
                    continue;
                }
                map[cy][cx] = map[cy][cx-1];
                min = Math.min(min,map[cy][cx]);
            }

            answer[i] = min;
        }




        return answer;
    }


}