package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Z_1074_1 {

    static int N, R, C, size;
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로
        size = (int) Math.pow(2,N);


        search(0,0,size, size, N-1);
        System.out.println(res);
    }

    static void search(int minx, int miny, int maxx, int maxy, int size) {
        if(size == -1) return;
        // 1사분면
        if(C < (minx+maxx)/2 && R < (miny + maxy)/2) {

            search(minx, miny, (minx+maxx)/2, (miny+maxy)/2, size-1);
        }

        // 2사분면
        if(C >= (minx+maxx)/2 && R < (miny + maxy)/2) {
            res = res + (int) Math.pow(2,size) * (int) Math.pow(2,size);
            search((minx+maxx)/2, miny, maxx, (miny+maxy)/2, size-1);
        }
        // 3사분면
        if(C < (minx+maxx)/2 && R >= (miny + maxy)/2) {
            res = res + ((int) Math.pow(2,size) * (int) Math.pow(2,size)) * 2;
            search(minx, (miny+maxy)/2, (minx+maxx)/2, maxy, size-1);
        }
        // 4사분면
        if(C >= (minx+maxx)/2 && R >= (miny + maxy)/2) {
            res = res + ((int) Math.pow(2,size) * (int) Math.pow(2,size)) * 3;
            search((minx+maxx)/2, (miny+maxy)/2, maxx, maxy, size-1);
        }
    }
}
