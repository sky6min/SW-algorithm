package test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class PG_연습장 {



    public static void main(String[] args) {
        int[] orders = {9, 20, 28, 18, 11};
        int[] courses = {30, 1, 21, 17, 28};
        solution(5,orders, courses);
    }

    static char map[][];

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        map = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = ' ';

            }
        }


        for(int i=0; i<n; i++) {
            String hint1 = Integer.toBinaryString(arr1[i]);
            String hint2 = Integer.toBinaryString(arr2[i]);
            char[] h1 = hint1.toCharArray(); // 01001
            char[] h2 = hint2.toCharArray(); // 11110
            int hIdx1 = h1.length-1;
            int hIdx2 = h2.length-1;
            System.out.println(hIdx2);
            for(int j=n-1; j>=0; j++) {
                if(hIdx1 == -1) {}
                else if(h1[hIdx1--] == '1') map[i][j] = '#';
                if(hIdx2 == -1) {}

                else if(h2[hIdx2--] == '1') map[i][j] = '#';
            }


            answer[i] = new String(map[i]);
        }


        return answer;
    }

}



