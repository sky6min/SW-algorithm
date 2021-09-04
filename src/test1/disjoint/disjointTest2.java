package test1.disjoint;

public class disjointTest2 {

    static int parent[] = new int[7+1];

    public static void main(String[] args) {

    }

    public static void make() {
        for(int i=1; i<=7; i++) {
            parent[i] = i;
        }
    }

    public static int find(int a) {
        if(a == parent[a]) return a;

        return parent[a] = find(parent[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parent[bRoot] = aRoot;
        return true;

    }
}
