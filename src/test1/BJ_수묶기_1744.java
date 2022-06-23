package test1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_수묶기_1744 {

    // 양수 규칙

    // 음수 규칙

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> pn = new ArrayList<>();
        List<Integer> nn = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x <= 0 ) {
                nn.add(x);
            }else {
                pn.add(x);
            }
        }

        // 오름차순
        Collections.sort(pn, Collections.reverseOrder());
        // 내림차순
        Collections.sort(nn);

        int i = 0;
        int sum = 0;
        while( i < pn.size()) {
            // 1이 아닌경우
            if(i + 1 < pn.size() && pn.get(i) != 1 && pn.get(i+1) != 1) {
                sum += pn.get(i++) * pn.get(i++);
            }else {
                sum += pn.get(i++);
            }

        }

        i = 0;

        while( i < nn.size()) {
            // 1이 아닌경우
            if(i + 1 < nn.size() ) {
                sum += nn.get(i++) * nn.get(i++);
            }else {
                sum += nn.get(i++);
            }

        }

        System.out.println(sum);
    }
}
