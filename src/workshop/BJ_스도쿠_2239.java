package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_스도쿠_2239 {

    static int map[][] = new int[9][9];
    static int endx = 0;
    static int endy = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++) {
            String str = br.readLine();
            for(int j=0; j<9; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }


        for (int i = 8; i >= 0 ; i--) {
            for (int j = 8; j >=0 ; j--) {
                if(map[i][j] == 0 && i == 8) {
                    endy = i;
                    endx = j;
                }
            }
        }
        System.out.println("endy : " + endy + "," + "endx : " + endx);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(map[i][j] == 0) {
                    for(int k=1; k<=9; k++) {
                        map[i][j] = k;
                        sdoku(i,j);

                    }
                }
            }
        }


    }

    static void sdoku(int i, int j) {
        boolean rCheck[] = new boolean[10];
        boolean cCheck[] = new boolean[10];
        for(int c=0; c<9; c++) {
            if(rCheck[map[i][c]] && map[i][c] != 0) {   // 겹치는게 있으면
                return;
            }
            rCheck[map[i][c]] = true;
        }

        for(int r=0; r<9; r++ ) {
            if(cCheck[map[r][j]]  && map[r][j] != 0) {
                return;
            }
            cCheck[map[r][j]] = true;
        }
        boolean boxCheck[] = new boolean[10];
        // 같은 상자 체크
        if(i <= 2 && j <= 2) {
            for(int y=0; y<3; y++) {
                for(int x=0; x<3; x++) {
                    if(boxCheck[map[y][x]] && map[y][x] != 0) {
                        return;
                    }
                    boxCheck[map[y][x]] = true;
                }
            }

        }else if(i <=2 && j<=5) {
            for(int y=0; y<3; y++) {
                for(int x=3; x<6; x++) {
                    if(boxCheck[map[y][x]] && map[y][x] != 0) {
                        return;
                    }
                    boxCheck[map[y][x]] = true;
                }
            }
        }else if(i <=2 && j<=8) {
            for(int y=0; y<3; y++) {
                for(int x=6; x<9; x++) {
                    if(boxCheck[map[y][x]] && map[y][x] != 0) {
                        return;
                    }
                    boxCheck[map[y][x]] = true;
                }
            }
        }else if(i <=5 && j <= 2){
            for(int y=3; y<6; y++) {
                for(int x=0; x<3; x++) {
                    if(boxCheck[map[y][x]] && map[y][x] != 0) {
                        return;
                    }
                    boxCheck[map[y][x]] = true;
                }
            }
        }else if(i <=5 && j <= 5){
            for(int y=3; y<6; y++) {
                for(int x=3; x<6; x++) {
                    if(boxCheck[map[y][x]] && map[y][x] != 0) {
                        return;
                    }
                    boxCheck[map[y][x]] = true;
                }
            }
        }else if(i <=5 && j <= 8){
            for(int y=3; y<6; y++) {
                for(int x=6; x<9; x++) {
                    if(boxCheck[map[y][x]] && map[y][x] != 0) {
                        return;
                    }
                    boxCheck[map[y][x]] = true;
                }
            }
        }else if(i <=8 && j <= 2){
            for(int y=6; y<9; y++) {
                for(int x=0; x<3; x++) {
                    if(boxCheck[map[y][x]] && map[y][x] != 0) {
                        return;
                    }
                    boxCheck[map[y][x]] = true;
                }
            }
        }else if(i <=8 && j <= 5){
            for(int y=6; y<9; y++) {
                for(int x=3; x<6; x++) {
                    if(boxCheck[map[y][x]] && map[y][x] != 0) {
                        return;
                    }
                    boxCheck[map[y][x]] = true;
                }
            }
        }else if(i <=8 && j <= 8){
            for(int y=6; y<9; y++) {
                for(int x=6; x<9; x++) {
                    if(boxCheck[map[y][x]] && map[y][x] != 0) {
                        return;
                    }
                    boxCheck[map[y][x]] = true;
                }
            }
        }


            for (int v = 0; v < 9; v++) {
                for (int b = 0; b < 9; b++) {
                    System.out.print(map[v][b]);
                }
                System.out.println();
            }


        // 현재 위치부터 반복
        for (; i < 9; i++) {
            for (; j < 9; j++) {
                if(map[i][j] == 0) {
                    for(int k=1; k<=9; k++) {
                        map[i][j] = k;
                        sdoku(i,j);

                    }
                    return;
                }
            }
        }

    }
}
