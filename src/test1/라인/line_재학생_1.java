package test1.라인;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class line_재학생_1 {
    static int from;
    static int to[];
    static char ary[];
    static int N;
    static int K;
    static int res = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        to = new int[K];
        ary = new char[N];

        ary = br.readLine().toCharArray();


        from = -1;
        int cnt = 0;
        Arrays.fill(to, N-1);
        for(int i=0; i<N; i++) {
            if(cnt >= K) {
                break;
            }
            if(ary[i] == '1') {
                to[cnt++] = i;
            }
        }


        for(int i=to[K-1]+1; i<N; i++) {
            if(ary[i] == '1' || i == N-1) {
                int front = to[0] - from - 1;
                int back = 0;
                if(i == N-1) {
                    back = (i - to[K-1]);
                }else {
                    back = (i - to[K-1]) -1;
                }

                int sum = (front +1) * (back + 1);
                res += sum;

                from = to[0];
                for(int j = 0; j<K-1; j++) {
                    to[j] = to[j+1];
                }
                to[K-1] = i;
            }

        }

        System.out.println(res);
    }
}
