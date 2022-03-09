package test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class PG_연습장 {



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

    static ArrayList<Node> nl;

    public static ArrayList<String> solution(String[] orders, int[] course) {
        String[] answer = {};
        int slength = 0;
        for(int i=0; i< orders.length; i++) {
            char[] order = orders[i].toCharArray();
            for(int j=0; j<order.length; j++) {
                if(!alphabet[order[j]]) {
                    alphabet[order[j]] = true;
                    slength++;
                }
            }

        }

        src = new char[slength];

        for(int i=0; i<200; i++) {
            if(alphabet[i]) {   // alphabet이 존재한다면
                src[srclength++] = (char)i;
            }
        }

        for(int i=0; i< course.length; i++) {
            nl = new ArrayList<>();
            tgtlength = course[i];
            tgt = new char[tgtlength];
            comb(orders,0,0);

            int max = Integer.MIN_VALUE;
            for(int j=0; j< nl.size(); j++) {
                max = Math.max(max, nl.get(j).cnt);
            }

            for(int j=0; j< nl.size(); j++) {
                Node node = nl.get(j);
                if(max == node.cnt) {
                    al.add(node.val);
                }
            }
        }
        Collections.sort(al);
        return al;
    }

    static void comb(String[] orders,int srcIdx, int tgtIdx) {
        if(tgtIdx == tgtlength) {
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
                nl.add(node);
            }
            return;
        }

        if(srcIdx == srclength) {
            return;
        }

        tgt[tgtIdx] = src[srcIdx];
        comb(orders,srcIdx+1, tgtIdx+1);
        comb(orders,srcIdx+1, tgtIdx);

    }

    static class Node {
        String val;
        int cnt;
    }
}



