package livecode;

import java.util.Scanner;

public class NQueenTest {

    static int N, cnt;
    static int col[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N+1];
        cnt = 0;

        setQueens(1);
        System.out.println(cnt);
    }

    private static void setQueens(int rowNo) {

        // 유망여부 체크 : rownNo - 1행까지

        if(!isAvailable(rowNo-1)) return;

        if(rowNo==N+1) {   // 마지막행까지 다 둔 경우
            cnt++;
            return;
        }

        // 현재 퀸 1열부터 N열까지 놓아보기
        // 놓았으면 다음 퀸 놓으러 가기
        for (int i = 1; i<= N; i++) {
            col[rowNo] = i; // i열에 놓아보기
            setQueens(rowNo+1);
        }
    }

    private static boolean isAvailable(int rowNo) {

        for (int k = 1; k < rowNo; k++) { // k: 이전퀸
            if(col[rowNo] == col[k] || Math.abs(col[rowNo] - col[k]) == (rowNo - k) ) return false;                   // 행차이와 열차이가 같으면 (대각선 검사)
        }
        return true;
    }
}
