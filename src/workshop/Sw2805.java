package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw2805 {

    static int sum;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            for (int i = 0; i < size; i++) {
                char[] temp = br.readLine().toCharArray();
                for(int j=0; j < size; j++) {
                    map[i][j] = temp[j] - '0';
                }
//                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//                String[] str = st.nextToken().split("");
//                for(int j=0; j < size; j++) {
//                    map[i][j] = Integer.parseInt(str[j]);
//                }
            }

            sum = 0;
            // 전략
            int wide = 0; // center 로부터 얼마나 멀어지나.
            int center = size / 2;
            int startX, endX;

            // 위에서 부터
            for(int i = 0; i < size; i++) {
                startX = center - wide;
                endX = center + wide;

                // 옆으로 가면서 startX ~ endX 까지 합
                for(int j = startX; j <= endX; j++) {
                    sum += map[i][j];
                }

                // wide를 늘이거나 줄이거나
                if( i < center) {
                    wide++;
                }else {
                    wide--;
                }
            }
            System.out.println("#" + t + " " + sum);
        }
    }
}
