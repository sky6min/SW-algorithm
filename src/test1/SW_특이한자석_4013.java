package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class SW_특이한자석_4013 {

    static int al[][];

    static int cmd[][];
    static int ary[] = new int[6];
    static int dir[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        al = new int[4][8];



        for(int t=1; t<=T; t++) {
            int K = Integer.parseInt(br.readLine());
            cmd = new int[K][2];
            dir = new int[4];
            for(int i=0; i<4; i++) {
                StringTokenizer st =new StringTokenizer(br.readLine());
                for(int j=0; j<8; j++) {
                    al[i][j] = Integer.parseInt(st.nextToken());

                }

            }

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 2; j++) {
                    cmd[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int res = 0;
            for(int k=0; k<K; k++) {
                int src = cmd[k][0]-1;
                int d = cmd[k][1];

                ary[0] = al[0][2];
                ary[1] = al[1][6];
                ary[2] = al[1][2];
                ary[3] = al[2][6];
                ary[4] = al[2][2];
                ary[5] = al[3][6];

                if(src == 0) {
                    rotate(0,d);
                    if(ary[0] != ary[1]) {
                        rotate(1,-d);

                        if(ary[2] != ary[3]) {
                            rotate(2,d);

                            if(ary[4] != ary[5]) {
                                rotate(3,-d);
                            }
                        }
                    }
                }else if(src == 1){
                    rotate(1,d);
                    if(ary[0] != ary[1]) {
                        rotate(0,-d);
                    }
                    else if(ary[2] != ary[3]) {
                        rotate(2,-d);

                        if(ary[4] != ary[5]) {
                            rotate(3,d);
                        }

                    }

                }else if(src == 2){
                    rotate(2, d);
                    if(ary[4] != ary[5]) {
                        rotate(3,-d);
                    }

                    if(ary[2] != ary[3]) {
                        rotate(1, -d);

                        if(ary[0] != ary[1]) {
                            rotate(0, d);
                        }
                    }

                }else if(src == 3){
                    rotate(3,d);
                    if(ary[4] != ary[5]) {
                        rotate(2,-d);

                        if(ary[2] != ary[3]) {
                            rotate(1,d);

                            if(ary[0] != ary[1]) {
                                rotate(0,-d);
                            }
                        }
                    }
                }

               /* src = 0 1 2 3
                0,1번  1,2번  2,3번

                0 1 // 2 3 // 4 5*/
            }
            if(al[0][0] == 1) {
                res += 1;
            }
            if(al[1][0] == 1) {
                res += 2;
            }
            if(al[2][0] == 1) {
                res += 4;
            }
            if(al[3][0] == 1) {
                res += 8;
            }
            System.out.println("#" + t + " " + res);
        }
    }

    static void rotate(int idx, int direction) {
        if(direction == 1) {
            int temp = al[idx][7];
            for(int i=7; i>0; i--) {
                al[idx][i] = al[idx][i-1];
            }
            al[idx][0] = temp;
        }else if (direction == -1) {
            int temp = al[idx][0];
            for(int i=0; i<7; i++) {
                al[idx][i] = al[idx][i+1];
            }
            al[idx][7] = temp;
        }

    }
}
