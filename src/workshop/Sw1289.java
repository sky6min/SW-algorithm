package workshop;

import java.util.Scanner;

public class Sw1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int t=1; t<=T; t++) {
            String mem = sc.nextLine();
            char[] ary = mem.toCharArray();
            char cur = '0';
            int cnt = 0;
            for(int i = 0; i< ary.length; i++) {

                if(ary[i] != cur) {
                    cnt++;
                    cur = ary[i];
                }
            }
            System.out.println("#"+ t + " " + cnt);
        }
    }
}
