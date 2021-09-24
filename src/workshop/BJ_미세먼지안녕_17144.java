package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_미세먼지안녕_17144 {

    static int map[][];
    static int map2[][];
    static int R, C, T;
    static Queue<Node> queue = new LinkedList<Node>();
    static int dx[] = { -1, 0, 1, 0};  // 좌 하 우 상
    static int dy[] = { 0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = map2[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        for( int t = 0; t < T; t++) {
            // 먼지 다 넣기
            for (int i = 0; i < R; i++) {

                for (int j = 0; j < C; j++) {
                    if(map[i][j] > 0) {
                        queue.offer(new Node(j,i));
                    }

                }
            }

            // 먼지 처리
            while(!queue.isEmpty()) {
                Node n = queue.poll();
                for(int i=0; i<4; i++) {


                }

            }


            // map 복사
        }

    }

    static class Node{
        int x;
        int y ;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
