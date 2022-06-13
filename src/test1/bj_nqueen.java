package test1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_nqueen {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N,cnt;
    static boolean[] colCheck;
    static boolean[][] queenPos;
    static void input(){
        N = scan.nextInt();
        colCheck = new boolean[N];
        queenPos = new boolean[N][N];
    }
    static void pro(){
        for (int col = 0; col < N; col++){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    queenPos[i][j] = false;
                }
            }
            colCheck[col] = true;
            checking(0,col);
            queen(1,col);
            colCheck[col] = false;
        }
    }
    static void queen(int x, int y){
        if (x == N-1) {
            cnt++;
            return;
        }
        for (int ny = 0; ny < N; ny++){

            if(colCheck[ny]) continue;
            if(queenPos[x][ny])continue;

            colCheck[ny] = true;
            queen(x+1,ny);
            colCheck[x] = false;
        }
    }

    static void checking(int x, int y){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(Math.abs(i-x) == Math.abs(j-y)){
                    queenPos[i][j] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        input();
        pro();
        System.out.println(cnt);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null||!st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}