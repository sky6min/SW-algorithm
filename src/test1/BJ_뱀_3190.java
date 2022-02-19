package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_뱀_3190 {

    static int N;
    static int K, L;
    static int map[][];
    static int rotate[][];
    static int dx[] = {1,0,-1,0}; // 우 하 좌 상
    static int dy[] = {0,1,0,-1};
    static Deque<Node> dq = new ArrayDeque<>(); // 뱀의 정보를 안다고해서 뱀의 x,y 정보를 어떻게 꺼내냐? o ㅁ -> ㅁ o 머리 + 1, 꼬리 - 1 , o o 머리 + 1   // 꼬리, 머리

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            map[n][m] = 1;
        }

        L = Integer.parseInt(br.readLine());
        rotate = new int[10000][2];
        for(int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            rotate[a][0] = 1;
            rotate[a][1] = st.nextToken().charAt(0); // L, D
        }


        int cnt = 0;
        int dir = 0;
        dq.offer(new Node(1,1));
        while(true) {
            cnt++;

            // 머리는 새로 만들어서 queue에 넣고, map에 표시도 해야함.
            Node head = dq.getLast();
            Node node = new Node();
            node.x = head.x + dx[dir]; // 머리 x좌표
            node.y = head.y + dy[dir]; // 머리 y좌표

            // 맵에 부딪히면
            if(node.x < 1 || node.x >= N+1 || node.y <1 || node.y >= N+1) {
                break;
            }

            if(map[node.y][node.x] == 1) { // 사과가 있다면,
                map[node.y][node.x] = 2;  // 자기 몸통이라고 표시
                dq.addLast(node);  // 머리 옮기기


            }else {  // 사과가 없다면
                if(map[node.y][node.x] == 2){ // 자기 몸통이라면
                    break;
                }else {
                    map[node.y][node.x] = 2;  // 자기 몸통이라고 표시
                    dq.addLast(node);  // 머리 옮기기
                    Node tail = dq.removeFirst(); // 꼬리 옮기기
                    map[tail.y][tail.x] = 0;
                }
            }

            if(rotate[cnt][0] == 1) {
                if(rotate[cnt][1] == 'D') {    // D는 오른쪽
                    if(dir == 3) { // dir == 3 이면
                        dir = 0;
                    }else {
                        dir++;
                    }
                }
                if(rotate[cnt][1] == 'L') {    // L은 왼쪽
                    if(dir == 0)  { // dir == 0 이면
                        dir = 3;
                    }else {
                        dir--;
                    }
                }
            }
        }

        System.out.println(cnt);


    }

    static class Node{
        int x;
        int y;

        public Node() {
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
