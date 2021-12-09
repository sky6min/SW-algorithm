package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sw_점심식사시간_2383 {

    static int N, srcIdx = 0;
    static ArrayList<Node> al = new ArrayList<>();
    static Node door[] = new Node[2];

    // 중복순열
    static int tgt[];
    static int tgtIdx = 0;
    static int src[] = {0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            // 값 추가
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int pos = Integer.parseInt(st.nextToken());
                    int x = j;
                    int y = i;
                    if(pos == 1) {
                        al.add(new Node(x,y,0));
                        tgtIdx++;
                    }else if(pos != 0 && pos != 1) {
                        door[srcIdx++] = new Node(x,y,0);
                    }
                }
            }

            // 중복 순열로 나누기
            comb(0);
        }

    }

    static void comb(int idx) {
        if(idx == tgtIdx ) {
            // 배치하고 알고리즘


        }

        for (int i = 0; i < srcIdx; i++) {
            tgt[idx] = src[i];

            comb(idx++);
        }
    }

    static class Node{
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
