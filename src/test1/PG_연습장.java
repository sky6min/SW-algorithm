package test1;


import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_연습장 {



    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }

    static boolean visited[][][];
    static Queue<Node> queue;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};

        char[][][] map = new char[5][5][5];
        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                char[] str = places[i][j].toCharArray();
                for (int k = 0; k < 5; k++) {
                    map[i][j][k] = str[k];
                }
            }
        }


        queue = new LinkedList<>();

        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(map[i][j][k] == 'P') {
                        visited = new boolean[5][5][5];
                        Node node = new Node();
                        node.x = k;
                        node.y = j;
                        node.val = 0;

                        queue.add(node);
                        while(!queue.isEmpty()) {
                            System.out.println(i);
                            Node nd = queue.poll();
                            visited[i][nd.y][nd.x] = true;

                            for (int l = 0; l < 4; l++) {
                                int rx = nd.x + dx[l];
                                int ry = nd.y + dy[l];
                                if(rx < 0 || rx >= 5 || ry < 0 || ry>= 5 || visited[i][ry][rx] || map[i][ry][rx] == 'X' || nd.val == 2) continue;

                                Node n = new Node();
                                n.y = ry;
                                n.x = rx;
                                n.val = nd.val + 1;
                                visited[i][ry][rx] = true;
                                if(n.val < 2 && map[i][ry][rx] == 'P') {
                                    System.out.println("답은 0");
                                    answer[i] = 0;
                                    queue.clear();
                                    break;
                                }

                                if(i == 1) {
                                    System.out.println("x좌표 : " + n.x + "," + "y좌표 : " + n.y );
                                }

                                queue.add(n);

                            }

                        }
                    }
                }
            }
            // bfs

        }


        return answer;
    }

    static class Node {
        int x;
        int y;
        int val;

    }
}



