package test1;

import java.util.LinkedList;

public class SW_k진수에서소수개수구하기 {
    public static void main(String[] args) {

        int ans = solution(437674,3);
        System.out.println("정답" + ans);
    }

    static int solution(int n , int k) {
        int answer = 0;
        boolean prime[] = new boolean[1000001];
        long N = 1000000;
        prime[0] = prime[1] = true;
        for(int i=2; i<=Math.sqrt(N); i++) {
            if(!prime[i]) {
                for(int j=i; j<=Math.sqrt(N); j+=i) prime[j] = true;
            }
        }

        int array[] = new int [100];
        int idx = 0;
        while(n>=k) {
            int val = n % k;
            n = (n-val) / k;
            array[idx++] = val;
        }
        array[idx] = n;

        int start = 0;
        int end = 0;

        for(int i=idx; i>=0; i--) {
            System.out.println(array[i]);
        }
        double v = 0;
        for(start=0; start<=idx+1; start++) {
            if(array[start] == 0) {
                if(!prime[(int)v]) answer++;
                System.out.println("정답 수 : " + v);
                v = 0;
                continue;
            }
            if(start > 0 && array[start-1] == 0 && array[start] != 0) end = start;
            v = v + array[start] * Math.pow(10,start-end);



        }

        return answer;

    }
}
