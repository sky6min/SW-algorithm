package test1;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PG_실패율 {

    public static void main(String[] args) {
        int[] stages = {2,1,2,6,2,4,3,3};
        solution(5,stages);
    }

    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static ArrayList<Integer> solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Integer> al = new ArrayList<>();

        double[] cnt = new double[N+2];
        double[] fail = new double[N+2];
        // 몇명이 있는지 count
        for(int i=0; i<stages.length; i++) {
            cnt[stages[i]]++;
        }

        // 실패율 계산
        double deno = stages.length;
        for(int i=1; i<N+2; i++) {
            if(deno == 0 && i != N+1) {
                Node node = new Node();
                node.N = i;
                node.F = 0;
                pq.add(node);
                continue;
            }
            if(i == N+1) break;
            Node node = new Node();
            node.N = i;
            node.F = cnt[i] / deno;
            pq.add(node);

            deno = deno - cnt[i];
        }

        for(int i=0; !pq.isEmpty(); i++) {
            Node node = pq.poll();
            if(node.F == 1 && node.N == N+1) continue;
            al.add(node.N);
        }

        return al;
    }

    static class Node implements Comparable<Node> {
        int N;
        double F;

        public int compareTo(Node obj) {
            if(this.F == obj.F) {
                if(this.N < obj.N) {
                    return -1;
                }else if(this.N >obj.N) {
                    return 1;
                }else {
                    return 0;
                }

            }else if(this.F < obj.F) {
                return 1;
            }else {
                return -1;
            }
        }
    }
}
