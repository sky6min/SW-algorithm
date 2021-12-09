package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Sw_점심식사시간_2383 {

    static int N, srcIdx = 0;
    static ArrayList<Node> al;
    static Node door[] = new Node[2];

    // 중복순열
    static int tgt[];
    static int tgtIdx = 0;
    static int src[] = {0, 1};

    // 우선순위 큐1
    static PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    // 우선순위 큐2
    static PriorityQueue<Integer> pq2 = new PriorityQueue<>();

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            res = Integer.MAX_VALUE;
            tgtIdx = 0;
            srcIdx = 0;
            al = new ArrayList<>();
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
                        door[srcIdx++] = new Node(x,y,pos);
                    }
                }
            }
            tgt = new int[tgtIdx];
            // 중복 순열로 나누기
            comb(0);
            System.out.println(res);
        }

    }

    static void comb(int idx) {
        if(idx == tgtIdx ) {
            // 배치하고 알고리즘
            //System.out.println(Arrays.toString(tgt));
            for (int i = 0; i < tgtIdx; i++) {
                if(tgt[i] == 0) {
                    // al 리스트의 인덱스와 첫번째 출구의 거리 계산하여 pq1에 추가.
                    Node node = al.get(i);
                    int dx = Math.abs(node.x - door[0].x);
                    int dy = Math.abs(node.y - door[0].y);
                    int dist = dx + dy;
                    pq1.add(dist);
                }else{
                    Node node = al.get(i);
                    int dx = Math.abs(node.x - door[1].x);
                    int dy = Math.abs(node.y - door[1].y);
                    int dist = dx + dy;
                    pq2.add(dist);

                }
            }

            // 1초가 지날때마다 pq의
            int cnt = 0;
            int door_cnt = 0;
            while(!pq1.isEmpty() || !pq2.isEmpty() || !q1.isEmpty() || !q2.isEmpty()) {
                cnt++;


                int q1_size = q1.size();
                for (int i = 0; i < q1_size; i++) {
                    int a = q1.poll();
                    a = a-1;
                    if(a == -door[0].time) {
                        door_cnt--;
                        continue;
                    }else {
                        q1.add(a);
                    }
                }

                int pq1_size = pq1.size();
                for (int i = 0; i < pq1_size; i++) {
                    int a = pq1.poll();
                    a = a-1;
                    if(a <= 0 && door_cnt < 3) {
                        q1.add(0);
                        door_cnt++;
                    }else {
                        pq1.add(a);
                    }
                    // if pq1의 요소값이 0이 되면
                    // q1 에 추가
                }

                int q2_size = q2.size();
                for (int i = 0; i < q2_size; i++) {
                    int a = q2.poll();
                    a = a-1;
                    if(a == -door[1].time) {
                        door_cnt--;
                        continue;
                    }else {
                        q2.add(a);
                    }
                }

                int pq2_size = pq2.size();
                for (int i = 0; i < pq2_size; i++) {
                    int a = pq2.poll();
                    a = a-1;
                    if(a <= 0 && door_cnt < 3) {
                        q2.add(0);
                        door_cnt++;
                    }else {
                        pq2.add(a);
                    }
                    // if pq1의 요소값이 0이 되면
                    // q1 에 추가
                }



            }
            res = Math.min(res,cnt);

           return;
        }

        for (int i = 0; i < srcIdx; i++) {
            tgt[idx] = src[i];

            comb(idx+1);
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
