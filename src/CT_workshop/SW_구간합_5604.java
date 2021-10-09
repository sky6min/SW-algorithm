package CT_workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_구간합_5604 {

    static int T;
    static long A, B, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        // 127 => 1 + 2 + 7
//        System.out.println(calcTen(128));
//        System.out.println(calcRet(128,1));
//        System.out.println(calcRet(128,10));

        for(int t= 1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Long.parseLong(st.nextToken());
            B = Long.parseLong(st.nextToken());

            ans = 0;
            long pos = 1;   // 자리수
            while( A <= B ) {   //

                // 시작 일부 부분
                // 8 + 9 = 17
                while( A % 10 != 0 && A <= B ) {
                    calc(A, pos);
                    A++;
                }

                if( A > B || (A == 0 && B == 0)) break;

                // 끝 일부 부분
                // 12 + 11 + 10 ( 3 + 2 + 1 )  ** 6
                while( B % 10 != 9 && A <= B) {
                    calc(B, pos);
                    B--;
                }

                // A 10   A 80
                // B 9    B 119

                A /= 10;
                B /= 10;
                // A : 8, B : 11
                // 덩어리 사각형
                long m = ( B - A + 1) * pos;   // m : 4   80 ~ 119 까지 4구간 있음
                // 80-81-82...89   |  90-91-92...99 | 100-101-102... | 110-111-112 ... 119
                for (int i = 0; i < 10; i++) {   // 10개
                    ans += m*i;   // 4*0 + 4*1 + 4*2....
                }


                pos *= 10;

            }
            System.out.println("#" + t + " " + ans);
        }



    }

    static void calc(long n, long t) {

        while( n > 0) {
            ans += ( n % 10 ) * t;
            n /= 10;
        }

    }

    static long calcTen(long n) {
        long sum = 0;

        while( n > 0) {
            sum += ( n % 10 );
            n /= 10;
        }

        return sum;
    }

    static long calcRet(long n, long t) {
        long sum = 0;

        while( n > 0) {
            sum += ( n % 10 ) * t;
            n /= 10;
        }

        return sum;
    }
}
