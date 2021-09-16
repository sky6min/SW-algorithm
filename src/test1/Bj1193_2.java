package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Bj1193_2 {

    static int dx[] = {1, -1}; // 상 하
    static int dy[] = {-1, 1}; // 상 하

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int D = 0;  // 방향

        int rx = 0;  // recent x 현재 x
        int ry = 0; // recent y 현재 y


        for(int i=0; i<N-1; i++) {   // N 번째


            if(ry+dy[D] < 0) // 상으로 이동
            {
                D = 1;
                rx = rx + 1;
                ry = ry;
                continue;
            }

            if(rx+dx[D] < 0) {
                D = 0;
                rx = rx;
                ry = ry + 1;
                continue;
            }

            ry = ry + dy[D];
            rx = rx + dx[D];
        }

        System.out.println();
    }
}
