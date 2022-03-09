package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PG_메뉴리뉴얼 {



    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] courses = {2,3,4};
        solution(orders,courses);
    }

    static char src[];
    static char tgt[];
    static boolean alphabet[] = new boolean[200];

    static int srclength;
    static int tgtlength;
    static ArrayList<String> al = new ArrayList<>();

    static ArrayList<Node> nl[];

    public static ArrayList<String> solution(String[] orders, int[] course) {
        nl = new ArrayList[course.length];
        for(int k=0; k<course.length; k++) {
            nl[k] = new ArrayList<>();
        }

        for(int i=0; i<orders.length; i++) {
            src = orders[i].toCharArray();
            srclength = src.length;

            for(int j=0; j< course.length; j++) {
                tgtlength = course[j];
                tgt = new char[tgtlength];

                comb(orders,j,0,0);

            }
        }
        for(int i=0; i< course.length; i++) {
            int max = Integer.MIN_VALUE;
            for(int j=0; j< nl[i].size(); j++) {
                max = Math.max(max, nl[i].get(j).cnt);
            }

            for(int j=0; j< nl[i].size(); j++) {
                Node node = nl[i].get(j);
                if(max == node.cnt) {

                    char[] str = node.val.toCharArray();
                    Arrays.sort(str);
                    String s = new String(str);
                    al.add(s);
                }
            }
        }

        Collections.sort(al);

        return al;
    }

    static void comb(String[] orders,int idx,int srcIdx, int tgtIdx) {
        if(tgtIdx == tgtlength) {

            int dup = 0;
            String s = new String(tgt);
            for(int i=0; i<nl[idx].size(); i++) {
                Node node = nl[idx].get(i);
                char[] ch1 = s.toCharArray();
                char[] ch2 = node.val.toCharArray();
                int cnt = 0;
                for(int j=0; j<ch1.length; j++) {
                    for(int k=0; k<ch2.length; k++) {
                        if(ch1[j] == ch2[k]) {
                            cnt++;
                        }
                    }
                }
                if(cnt == ch1.length) {
                    dup = 1;
                }

            }

            if(dup == 1) return;



            int cnt = 0;
            for(int i = 0; i < orders.length; i++) {
                char[] temp = orders[i].toCharArray();
                int t = 0;
                for(int j=0; j<tgt.length; j++) {

                    for(int k=0; k<temp.length; k++) {
                        if(tgt[j] == temp[k]) {
                            t++;
                        }
                    }
                }
                if(t == tgt.length) {
                    cnt++;
                }
            }
            if( cnt >= 2) {
                Node node = new Node();
                String str = new String(tgt);
                node.val = str;
                node.cnt = cnt;

                nl[idx].add(node);
            }
            return;
        }

        if(srcIdx == srclength) {

            return;
        }

        tgt[tgtIdx] = src[srcIdx];
        comb(orders, idx,srcIdx+1, tgtIdx+1);
        comb(orders, idx,srcIdx+1, tgtIdx);

    }

    static class Node {
        String val;
        int cnt;
    }
}



