package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test {
    static ArrayList<Integer> al[] = new ArrayList[5];
    public static void main(String[] args) {

        for(int i=0; i<5; i++) {
            al[i] = new ArrayList<Integer>();
        }

        Integer num[][] = new Integer[5][4];
        Arrays.sort(num[4], Collections.reverseOrder());
        System.out.println(num[0].length);

    }
}
