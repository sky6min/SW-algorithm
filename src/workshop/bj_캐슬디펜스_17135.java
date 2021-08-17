package workshop;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_캐슬디펜스_17135 {

    static int N, M, D;
    static int map[][];
    static ArrayList<Node> eList = new ArrayList<>();
    static ArrayList<Node> tgtList = new ArrayList<>();
    static ArrayList<Node> srcList = new ArrayList<>();
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 적 리스트 생성
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) {
                if(Integer.parseInt(st.nextToken()) == 1) eList.add(new Node(m,n));

            }
        }

        // 궁수가 생성될 수 있는 전체 위치
        for(int n=0; n<N; n++) {
            srcList.add(new Node(n,N));
        }

        comb(0,0);
    }

    static void comb(int tgtIdx, int srcIdx) {
        if(tgtIdx == 3) {

            bfs();
        }
        if(srcIdx == N) return;

        tgtList.add(srcList.get(srcIdx));

        comb(tgtIdx+1, srcIdx+1);
        comb(tgtIdx, srcIdx+1);
    }

    static void bfs() {
        queue.clear();

        queue.offer(tgtList.get(0));

        while(true) {


        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
