package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Sw_보물상자비밀번호_5658 {

    static Queue<Character> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t= 1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            char[] src = br.readLine().toCharArray();

            for (int i = 0; i < src.length; i++) {
                queue.offer(src[i]);
            }

            int cnt = N / 4;
            // 전체 반복 횟수

            for (int i = 0; i < cnt; i++) {
                // 한 줄당
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < cnt; k++) {
                        char node = queue.poll();
                        String charToHex = Integer.toHexString(node);
                        sb.append(charToHex);
                        queue.offer(node);
                    }

                    sb.toString()
                    System.out.println(sb.toString());

                }

            }

        }
    }
}
