package livecode;

import java.util.Arrays;

public class CombinationTest {
    static int N=3, R=2;
    static int[] numbers;
    static int[] input;

    public static void main(String[] args) {
        numbers = new int[R];
        input = new int[] {1, 4 ,7};

        combination(0,0);
    }

    private static void combination(int cnt, int start) {

        if(cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        // start 위치의 수부터 가능한 수 모두 고려
        for(int i = start; i < N; i++) {  // i : 인덱스

            numbers[cnt] = input[i];

            // 다음 자리순열 뽑으러 gogo
            combination(cnt+1, i+1);
        }
    }
}
