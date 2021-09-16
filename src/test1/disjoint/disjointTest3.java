package test1.disjoint;

public class disjointTest3 {
    static int N;
    static int parent[];

    public static void main(String[] args) {

    }

    static void make() {

    }

    static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int aroot = find(a);
        int broot = find(b);
        if(aroot == broot) return true;

        parent[broot] = aroot;
        return false;
    }
}
