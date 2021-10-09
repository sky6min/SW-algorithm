package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_회전초밥_2577 {

    static int N, d, k, c, max;
    static int count;   // 현재 선택에서 초밥의 종류의 수
    static int select[] = new int[3001];   // k=5, 빈도수 배열 select[4] = 3 4번 종류가 3개 있다.

    static int[] src;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());  // 쿠폰 처음부터 이미 선택한 종류 - 미리 계산

        src = new int[N];
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(br.readLine());
        }

        // 쿠폰 초기 계산
        select[c] = 1;  // 초밥 종류의 빈도수
        count = 1;    // 초밥 종류의 개수

        // 맨앞 k개부터 계산
        for (int i = 0; i < k; i++) {
            if(select[src[i]] == 0) count++;   // 아직 없던 종류이므로 count 증가
            select[src[i]]++;
        }

        max = Math.max(max, count);

        for (int i = k; i < N + k - 1; i++) {
            // 맨 앞 접시
            int dish = src[i-k];
            select[dish]--;
            if(select[dish] == 0) count--;

            // 맨 뒤에 새 접시 추가
            if( i < N ) {
                dish = src[i];
            }else {
                dish = src[i-N];   // i == N src[N-N] src[0]
            }

            if ( select[dish] == 0) count++;
            select[dish]++;

            max = Math.max(max, count);
        }
    }

}
