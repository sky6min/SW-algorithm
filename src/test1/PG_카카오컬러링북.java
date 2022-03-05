package test1;

public class PG_카카오컬러링북 {


    static class Solution {
        int M, N;
        int cnt = 0;
        int part = 0;
        int max = Integer.MIN_VALUE;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int [][] map;
        boolean[][]  visited;
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;
            M = m;
            N = n;


            map = new int[m][n];
            visited = new boolean[m][n];

            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    map[i][j] = picture[i][j];
                }

            }
            for(int i=1; i<m*n; i++) {

                for(int j=0; j<m; j++) {
                    for(int k=0; k<n; k++) {
                        if(picture[j][k] == i && !visited[j][k]) {
                            part = part + 1;
                            cnt = 0;
                            dfs(j,k,i);
                            max = Math.max(max, cnt);
                        }
                    }
                }
            }


            int[] answer = new int[2];
            numberOfArea = part;
            maxSizeOfOneArea = max;
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        void dfs(int m, int n, int val) {
            visited[m][n] = true;
            cnt = cnt + 1;

            for(int i=0; i<4; i++) {
                int rx = n + dx[i];
                int ry = m + dy[i];
                if(rx < 0 || rx >= N || ry < 0 || ry >= M || visited[ry][rx] || map[ry][rx] != val) continue;
                dfs(ry,rx,val);
            }
        }
    }
}
