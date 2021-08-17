package workshop;

import java.util.Scanner;

public class Sw1208 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ary[] = new int[100];

        for(int t=1; t<=10; t++) {
            int dump = sc.nextInt();

            for (int i = 0; i < 100; i++) {
                ary[i] = sc.nextInt();
            }

            int max = 1;
            int min = 100;
            int maxIndex=0;
            int minIndex=0;
            for(int j=0; j<dump; j++) {
                for (int i = 0; i < 100; i++) {

                    if (max != Math.max(max, ary[i])) {
                        max = ary[i];
                        maxIndex = i;
                    }
                    if (min != Math.min(min, ary[i])) {
                        min = ary[i];
                        minIndex = i;
                    }
                }
                ary[maxIndex]--;
                ary[minIndex]++;
                max = ary[maxIndex];
                min = ary[minIndex];
            }
            for(int i=0; i<100; i++) {
                max = Math.max(max,ary[i]);
                min = Math.min(min,ary[i]);
            }
            int res = max-min;
            System.out.println("#" + t + " " + res);
        }
    }
}
