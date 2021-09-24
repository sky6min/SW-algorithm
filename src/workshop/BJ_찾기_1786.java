package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_찾기_1786 {
    static char[] tgt;
    static char[] p;
    static int[] pi;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tgt = br.readLine().toCharArray();
        p = br.readLine().toCharArray();
        pi = new int[p.length];
        int j = 0;
        for(int i=1; i<p.length; i++) {

            while( j>0 && p[i] != p[j] ) j = pi[j-1];

            if(p[i] == p[j]) pi[i] = ++j;

        }
        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        j = 0;
        for(int i=0; i<tgt.length; i++) {

            while( j>0 && tgt[i] != p[j] ) j = pi[j-1];

            if(tgt[i] == p[j]) {   // 두 글자 일치
                if(j == p.length-1) {
                    cnt++;
                    list.add((i+2)- p.length);
                    j = pi[j];
                }
                else {
                    j++;
                }
            }
        }

        System.out.println(cnt);
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
