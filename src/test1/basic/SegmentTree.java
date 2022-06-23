package test1.basic;

public class SegmentTree {

    long tree[];
    int treeSize;

    public SegmentTree(int arrSize) {

        int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));

        this.treeSize =  (int) Math.pow(2,h+1);

        tree = new long[treeSize];

    }

    public long init(long[] arr, int node, int start, int end) {

        // leaf 노드인 경우
        if (start == end) {
            return tree[node] = arr[start];
        }

        return tree[node] =
                init(arr, node * 2, start, (start + end) / 2)
                + init(arr,node * 2 + 1, (start + end) / 2 + 1, end);

    }

    public void update(int node, int start, int end, int idx, long diff) {

    }

    public static void main(String[] args) {


    }
}
