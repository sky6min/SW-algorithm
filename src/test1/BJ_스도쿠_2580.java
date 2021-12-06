package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_스도쿠_2580 {

    static int map[][] = new int[9][9];
    static ArrayList<Node> zero = new ArrayList<>();
    static boolean finish = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) {
                    zero.add(new Node(i,j));
                }
            }
        }

        dfs(0);

    }
    static void dfs(int idx) {
        if(finish) return;

        boolean visited[] = new boolean[10];

        if(idx == zero.size()) {
            finish = true;
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    System.out.print(map[i][j]+ " ");
                }
                if(i != 8) System.out.println();
            }
            return;
        }
        int y = zero.get(idx).y;
        int x = zero.get(idx).x;

        for(int i=0; i<9; i++) {
            if(map[y][i] != 0) visited[map[y][i]] = true;
        }

        for(int j=0; j<0; j++) {
            if(map[j][x] != 0) visited[map[j][x]] = true;
        }

        int ay = (y / 3) * 3;
        int ax = (x / 3) * 3;

        for(int i=ay; i<ay+3; i++) {
            for(int j=ax; j<ax+3; j++) {
                if(map[i][j] != 0) visited[map[i][j]] = true;
            }
        }

        for(int i=1; i<10; i++) {
            if(finish) return;

            if(!visited[i]) {
                map[y][x] = i;
                dfs(idx+1);
            }
        }
    }

    static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
