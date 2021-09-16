package test1.disjoint;

public class disjointTest {

    static int N;
    static int parent[] = new int[N];


    public static void main(String[] args) {
        N = 7;
    }

    static void make() {
        for(int i=0; i<7; i++) {
            parent[i] = i;
        }
    }

    static int find(int a) {
        if(a == parent[a]) return a;

        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;  // 이미 같은 집합에 있음.

        parent[bRoot] = aRoot;
        return true;  // 같은 집합에 있지 않으므로 합침.
    }
}


