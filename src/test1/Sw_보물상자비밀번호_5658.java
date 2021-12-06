package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Sw_보물상자비밀번호_5658 {

    static Deque<Character> queue = new ArrayDeque<>();
    static double res[];
    static int idx;
    static Set<Double> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t= 1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            char[] src = br.readLine().toCharArray();

            set = new HashSet<Double>();
            res = new double[N];
            Arrays.fill(res,Integer.MAX_VALUE);
            idx = 0;
            for (int i = 0; i < src.length; i++) {
                queue.offer(src[i]);
            }

            int cnt = N / 4;
            // 전체 반복 횟수

            for (int i = 0; i < cnt; i++) {
                // 각 모서리 4개
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder();
                    //  cnt 개수만큼 stringBuilder에 저장
                    for (int k = 0; k < cnt; k++) {
                        char node = queue.poll();
                        sb.append(node);
                        queue.offer(node);
                    }
                    // sb값을 10진수로 변환하여 배열에 저장

                    toDecimal(sb.toString(), cnt-1);


                }
                char node = queue.removeLast();
                queue.addFirst(node);
            }

            // 배열을 정렬

            Arrays.sort(res);
            System.out.println("#" + t + " " + res[res.length-K-1]);
            System.out.println(Arrays.toString(res));
        }
    }

    static void toDecimal(String tgt, int cnt) {
        char[] src = tgt.toCharArray();
        double sum = 0;
        for(int i=0; i<src.length; i++) {
            if(src[i] > '9') {
                double t1 =  (src[i] - 'A' + 10) *  Math.pow(16, cnt);

                sum += t1;
            }else {
                double t1 = (src[i] - '0') * Math.pow(16,cnt);
                sum += t1;

            }
            cnt--;
        }
        if(set.add(sum)) {
            res[idx] = sum;
            idx++;
        }
    }
}
