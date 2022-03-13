package test1;

import java.util.LinkedList;
import java.util.Queue;

public class PG_거리두기확인하기 {


    class Solution {
        boolean visited[][][];
        Queue<Node> queue;
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};

        int[] solution(String[][] places) {
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
                                    if(n.val <= 2 && map[i][ry][rx] == 'P') {
                                        answer[i] = 0;
                                        queue.clear();
                                        break;
                                    }



                                    // n.val < 2 이고 map[i][ry][rx] == 'P'

                                    queue.offer(n);

                                }

                            }
                        }
                    }
                }
                // bfs

            }


            return answer;
        }

        class Node {
            int x;
            int y;
            int val;

        }
    }
}
