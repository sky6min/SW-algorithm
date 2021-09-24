package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_맥주마시면서걷기_9205 {

    static int matrix[][];
    static boolean canGo[][];
    static Node node[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int n = Integer.parseInt(br.readLine());
            matrix = new int[n+2][n+2];
            canGo = new boolean[n+2][n+2];
            node = new Node[n+2];

            for(int i=0; i<n+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                node[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            }
            for(int i=0; i<n+2; i++) {

                for(int j=0; j<n+2; j++) {
                    matrix[i][j] = Math.abs(node[i].x - node[j].x) + Math.abs(node[i].y - node[j].y);
                    if(matrix[i][j] <= 1000) canGo[i][j] = true;

                }

            }
            for(int k=0; k<n+2; k++) {

                for(int i=0; i<n+2; i++) {
                    if(i==k) continue;
                    for(int j=0; j<n+2; j++) {
                        if(i==j || k==j) continue;

                        if(canGo[i][k] && canGo[k][j])
                            canGo[i][j] = true;
                    }

                }

            }
            System.out.println(canGo[0][n+1] ? "happy" : "sad");
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
