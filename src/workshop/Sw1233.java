package workshop;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw1233 {

    static int N;
    static char[] ary;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            ary = new char[N+1];
            for(int n=0; n<N; n++) {
                ary[n] = br.readLine().split(" ")[1].charAt(0);
            }

            int b = search(1)? 1: 0;

            System.out.println("#" + t + " " + b);
        }

    }

    static Boolean search(int i) {

        if(i > N) return false;

        if(Character.isDigit(ary[i])) { // 숫자 노드 ,   자식 노드가 없어야 한다.
            if( i * 2 > N) return true;
            return false;
        }else { // 연산자
            return search(i * 2) && search(i * 2 + 1);
        }
    }
}
