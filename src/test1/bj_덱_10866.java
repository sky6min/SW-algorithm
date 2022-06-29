package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj_덱_10866 {

    static Deque<String> deque = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String token = st.nextToken();
            if(token.equals("push_back")) {
                deque.addLast(st.nextToken());
            }else if(token.equals("push_front")) {
                deque.addFirst(st.nextToken());
            }else if(token.equals("pop_back")) {
                if(deque.size() == 0) {
                    System.out.println(-1);
                }else {
                    System.out.println(deque.pollLast());
                }

            }else if(token.equals("pop_front")) {
                if(deque.size() == 0) {
                    System.out.println(-1);
                }else {
                    System.out.println(deque.pollFirst());
                }
            }else if(token.equals("size")) {
                System.out.println(deque.size());
            }else if(token.equals("empty")) {
                if(deque.size() == 0) {
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }else if(token.equals("front")) {
                if(deque.size() == 0) {
                    System.out.println(-1);
                }else {
                    System.out.println(deque.getFirst());
                }
            }else if(token.equals("back")) {
                if(deque.size() == 0) {
                    System.out.println(-1);
                }else {
                    System.out.println(deque.getLast());
                }
            }

        }

    }
}
