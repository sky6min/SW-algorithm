package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_치킨배달_15686ans {
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static List<int[]> house, src; // src 치킨집

    static int[] index;  // np 로 변경

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        house = new ArrayList<int[]>();
        src = new ArrayList<int[]>();

        for (int i=0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if( a == 1) house.add(new int[] {i, j});
                else if(a == 2) src.add(new int[] {i, j});
            }
        }

        // 111 뒤에서 채운다 index 배열
        // src 길이인데 여기에 M개 만큼 1을 뒤에서 채운다. 0000011111 -> 1111100000 (M;5)
        index = new int[src.size()];

        // 정렬되어 있다. (가장 작은수로)
        for(int i=0; i< M; i++) {
            index[ index.length - 1 - i] = 1;
        }

//        while(true) {
//            // 위 index 배열은 순열이 완성 => 조합에  사용될 0과 1이 만들어졌다.
//            if (!np()) break;
//
//        }
    }
}
