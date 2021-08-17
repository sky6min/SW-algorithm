package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw1861 {

    static int N, COUNT=1, cur, max=1, maxIdx=Integer.MAX_VALUE;
    static int start;
    static int map[][];
    static boolean visited[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            max=1;
            maxIdx=Integer.MAX_VALUE;
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++ ) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    cur = map[i][j];
                    if(visited[i][j]) continue;

                    start = map[i][j];
                    search(i,j);


                    COUNT=1;
                }
            }
            System.out.print("#" + t + " ");
            System.out.println(maxIdx + " " + max);
        }
    }

    static void search(int i, int j) {

        for(int k=0; k<4; k++) {
            cur = map[i][j];
            int rx = j+dx[k];
            int ry = i+dy[k];

            if(rx<0 || rx>=N || ry<0 || ry>=N || map[ry][rx] != cur+1 ) continue;

            COUNT++;

            visited[ry][rx] = true;

            max = Math.max(max,COUNT);
            if(max == COUNT && start<maxIdx) {
                maxIdx = start;
            }

            search(ry, rx);

            COUNT--;
        }

    }
}
