package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_동철이의일분배_1865 {

    static int N;
    static double tgt[];
    static boolean visited[];
    static double src[][];
    static double res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            tgt = new double[N];
            visited = new boolean[N];
            src = new double[N][N];
            res = 0;
            for (int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int m = 0; m < N; m++) {
                    src[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            perm(0, 1, 0);
            System.out.println("#" + t + " " + String.format("%.6f",res));
        }
    }

    static void perm(int tgtIdx, double percent, int stage) {
        if(tgtIdx == N) {
            res = Math.max(res,percent * 100);
            return;
        }

        if(percent * 100 < res) {
            //System.out.println("percent : " + percent);
            return;
        }

        for(int i=0; i<N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            tgt[tgtIdx] = src[stage][i];
            if(percent * tgt[tgtIdx]  < res) {
                //System.out.println("percent * tgt[tgtIdx] : " + percent * tgt[tgtIdx]);
                visited[i] = false;
                continue;
            }
            perm(tgtIdx+1,percent*tgt[tgtIdx]/100,stage+1);
            visited[i] = false;
        }
    }
}
