package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_활주로건설_4131 {

    static int T, N, X, ans;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j< N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = 0;

            // 왼쪽 -> 오른쪽
            for (int i = 0; i < N; i++) {
                int diff = 0; // 앞 뒤 높이의 차이
                int flat = 1; // 평편한 길이의 수 (연속)
                int curr = map[i][0];  // 맨 앞 시작
                boolean isSuccess = true;

                // j 가 이동 -->
                for (int j = 1; j < N; j++) {   // j : 1부터
                    diff = map[i][j] - curr;  // 뒤 - 앞

                    if( diff == 0) {  // 뒤, 앞 높이가 같다
                        flat++;
                        curr = map[i][j];
                    }else if(diff == 1) {   // up
                        if( flat >= X) {   // 경사로를 놓을 수 있다.
                            curr = map[i][j];
                            flat = 1;
                        }else {
                            isSuccess = false;
                            break; // 현제 행 실패
                        }
                    }else if ( diff == -1) {
                        // 남은 길이가 경사로의 X 만큼 충분한지
                        if( N -j >= X) {
                            // 평평함이 X 인지 체크
                            flat = 1;
                            curr = map[i][j];
                            boolean isSame = true;

                            for(int k = j + 1; k < j + X; k++) {
                                if(curr != map[i][k]) {
                                    isSame = false;
                                    break;
                                }
                            }
                            if ( isSame ) {  // 경사로 X 길이만큼 flat
                                flat = 0;
                                j = j + X - 1;  // j는 for 문 증가
                            }else {
                                isSuccess = false;
                                break;
                            }

                        }else {
                            isSuccess = false;
                            break;
                        }
                    }else {
                        isSuccess = false;
                        break;
                    }
                }

                if (isSuccess) ans++;
            }

            // 위 -> 아래
            for (int i = 0; i < N; i++) {
                int diff = 0; // 앞 뒤 높이의 차이
                int flat = 1; // 평편한 길이의 수 (연속)
                int curr = map[0][i];  // 맨 앞 시작
                boolean isSuccess = true;

                // j 가 이동 -->
                for (int j = 1; j < N; j++) {   // j : 1부터
                    diff = map[j][i] - curr;  // 뒤 - 앞

                    if( diff == 0) {  // 뒤, 앞 높이가 같다
                        flat++;
                        curr = map[j][i];
                    }else if(diff == 1) {   // up
                        if( flat >= X) {   // 경사로를 놓을 수 있다.
                            curr = map[j][i];
                            flat = 1;
                        }else {
                            isSuccess = false;
                            break; // 현제 행 실패
                        }
                    }else if ( diff == -1) {
                        // 남은 길이가 경사로의 X 만큼 충분한지
                        if( N -j >= X) {
                            // 평평함이 X 인지 체크
                            flat = 1;
                            curr = map[j][i];
                            boolean isSame = true;

                            for(int k = j + 1; k < j + X; k++) {
                                if(curr != map[k][j]) {
                                    isSame = false;
                                    break;
                                }
                            }
                            if ( isSame ) {  // 경사로 X 길이만큼 flat
                                flat = 0;
                                j = j + X - 1;  // j는 for 문 증가
                            }else {
                                isSuccess = false;
                                break;
                            }

                        }else {
                            isSuccess = false;
                            break;
                        }
                    }else {
                        isSuccess = false;
                        break;
                    }
                }

                if (isSuccess) ans++;
            }

            System.out.println("#" + t + " " + ans);
        }
    }
}
