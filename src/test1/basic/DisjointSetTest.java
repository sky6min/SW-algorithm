package test1.basic;

import java.util.Arrays;

public class DisjointSetTest {

    static int N;
    static int parents[];

    static void make() {

        for(int i=0; i<N; i++) {
            parents[i] = i;
        }

    }

    static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parents[aRoot] = bRoot;

        return true;
    }


    public static void main(String[] args) {
        N = 5;
        parents = new int[N];

        // make set
        make();
        System.out.println(union(0,1));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(2,1));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(3,2));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(4,3));
        System.out.println(Arrays.toString(parents));

        System.out.println("================find====================");
        System.out.println(find(4));
        System.out.println(Arrays.toString(parents));
        System.out.println(find(3));
        System.out.println(Arrays.toString(parents));
        System.out.println(find(2));
        System.out.println(Arrays.toString(parents));
        System.out.println(find(0));
        System.out.println(Arrays.toString(parents));
        System.out.println(find(1));
        System.out.println(Arrays.toString(parents));
    }
}
