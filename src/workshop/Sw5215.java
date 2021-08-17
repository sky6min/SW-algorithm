package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw5215 {

    static token tk[];
    static boolean visited[];
    static int max;
    static int L, N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            tk = new token[N];
            visited = new boolean[N];
            max = 0;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());
                tk[i] = new token(score,cal);
            }

            //알고리즘
            subset(0);
            System.out.println("#" + t + " " + max);
        }
    }

    static void subset(int srcIdx) {

        //기저조건
        if(srcIdx == N) {
            int cal = 0;
            int score = 0;
            for(int i=0; i<N; i++) {
                if(visited[i]) {
                    cal += tk[i].cal;
                    score += tk[i].score;
                }
            }
            if(cal <= L) max=Math.max(score,max);
            return;
        }

        visited[srcIdx] = true;
        subset(srcIdx+1);

        visited[srcIdx] = false;
        subset(srcIdx+1);
    }

    static class token{
        int score;
        int cal;

        public token(int score, int cal) {
            this.score = score;
            this.cal = cal;
        }


    }
}
