package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_사람네트워크2_1263 {

    static int T, N;
    static int BIG = 999999;
    static int [][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T;t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            matrix = new int[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    if( n == 0 && i != j) matrix[i][j] = BIG;
                    else matrix[i][j] = n;
                }
            }

            for(int k = 0; k < N; k++) {   // 경유지

                for(int i = 0; i < N; i++ ) {   // 출발지

                    if( i == k ) continue;   // 거쳐가는 정점과 시작 정점이 같으면 skip

                    for(int j = 0; j < N; j++) {   // 도착지

                        if( j == k || i == j ) continue;   // 거쳐가는 정점과 거쳐가는 정점이 같으면 skip // 시작 도착 같은 경우 skip

                        // [i -> j 비용]과 [i -> k] + [k -> j]
                        matrix[i][j] = Math.min(matrix[i][j] ,  matrix[i][k] + matrix[k][j]);
                    }
                }
            }

            // 가장 최소비용인 사람 정점
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for(int j =0; j< N; j++) {
                    sum += matrix[i][j];
                }

                min = Math.min(min, sum);
            }
            System.out.println("#" + t + " " + min);
        }
    }
}
