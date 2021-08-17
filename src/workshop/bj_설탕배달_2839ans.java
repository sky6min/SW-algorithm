package workshop;

import java.util.Scanner;

public class bj_설탕배달_2839ans {

    static int N, min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        min = 5000;

        comb(0,0); // 첫번째: 5를 사용하는 횟수(5kg 봉지의 수), 두번째: 3을 사용하는 횟수(3kg 봉지의 수)
        min = min == 5000 ? -1:min;
        System.out.println(min);
        sc.close();
    }

    //
    static void comb(int five, int three) {
        int sum = five*5 + three*3;

        // 기저조건
        if(sum == N) {
            min = Math.min(min, five+three);
            return;
        }else if( sum > N  ) {
            return;
        }

        comb(five+1, three);
        comb(five, three+1);

    }
}
