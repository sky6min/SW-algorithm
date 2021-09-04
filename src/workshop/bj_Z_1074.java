package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1  2
// 3  4
public class bj_Z_1074 {

    static int N,r,c, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        N = (int) Math.pow(2, N);

        // 초기 원점

        z(0,0);

        System.out.println(ans);
    }

    static void z(int y, int x) {

        if(N == 1) return;

        N /= 2;    // 8이면 4가 됨

        if( r < y + N && c < x + N ) { // 1구간
            ; // ans 미리 계산 X,  원점이동 X
            z(y,x);
        }else if( r < y + N && c >= x + N) { // 2구간
            ans += N*N*1;
            x += N;
            z(y,x);


        }else if (r >= y + N && c < x + N) { // 3구간
            ans += N*N*2;
            y += N;
            z(y,x);

        }else if (r >= y + N && c >= x + N) { // 4구간
            ans += N*N*3;
            x += N;
            y += N;
            z(y,x);
        }
    }
}
