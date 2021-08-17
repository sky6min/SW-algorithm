package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sw_링크드리스트_1228 {
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            list.clear();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<K; k++) {
                st.nextToken();
                int tgt = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                for(int y=0; y<Y; y++) {
                    list.add(tgt++,Integer.parseInt(st.nextToken()));
                }

            }

            System.out.print("#" + t);
            for(int i=0; i<10; i++) {
                System.out.print(" "+list.get(i));
            }
            System.out.println();
        }

    }
}
