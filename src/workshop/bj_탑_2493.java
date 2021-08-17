package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_탑_2493 {

    static Stack<int[]> stack = new Stack<>();
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 탑 1개씩 읽어서 바로 처리
        for(int i=1; i <= N; i++) {

            int height = Integer.parseInt(st.nextToken());

            // 높이와 stack 에 들어있는 높이들을 계산 처리
            while(!stack.isEmpty() ) {
                // pop() 꺼낸다. 스택에서 제거
                // peek() 꺼내지 않고 알려준다.

                if(stack.peek()[1] >=height) {
                    System.out.println(stack.peek()[0] + " ");
                    break;
                }

                stack.pop();
            }

            if(stack.isEmpty()) {
                System.out.println("0 ");
            }
            stack.push(new int[] {i, height});
        }

    }
}
