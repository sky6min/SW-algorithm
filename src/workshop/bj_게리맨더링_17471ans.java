package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_게리맨더링_17471ans {

    static int N, min;
    static int[][] matrix;
    static boolean[] select;
    static boolean[] visit;   // 두 개의 그룹에서 각 그룹 내에 연결성 관리 // 두 그룹이 공유

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N+1][N+1]; // 0 : 인구수(j)
        select = new boolean[N+1];
        min = Integer.MAX_VALUE;
        
        // 인구수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=  N; i++) {
            matrix[i][0] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for(int j=1; j<= n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        subset(1);
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static void subset(int srcIdx) {
        //기저조건
        if (srcIdx == N+1) {

            check();
            // complete code
            return;
        }

        select[srcIdx] = true;
        subset(srcIdx + 1);
        select[srcIdx] = false;
        subset(srcIdx + 1);
    }

    // A, B 2개 그룹 생각
    // 그룹 각각 갯수와 연결성 체크 => 두 그룹의 인구수의 차이를 계산 => MIN
    // 연결성 체크 : bfs visit
    static void check() {
        visit = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<Integer>();

        // A 그룹
        for(int i = 1; i <= N; i++) {
            if(select[i]) {
                visit[i] = true;
                queue.offer(i);
                break;
            }
        }

        if (queue.size() == 0 || queue.size() == N) return;

        while(!queue.isEmpty()) {
            int v = queue.poll();
            for(int i = 1; i<=N; i++) {
                int adj = matrix[v][i];
                if(adj != 0 && !visit[adj] && select[adj]) {
                    visit[adj] = true;
                    queue.offer(adj);
                }
            }
        }
        // B그룹
        for(int i = 1; i <= N; i++) {
            if(!select[i]) {
                visit[i] = true;
                queue.offer(i);
                break;
            }
        }

        while(!queue.isEmpty()) {
            int v = queue.poll();
            for(int i = 1; i<=N; i++) {
                int adj = matrix[v][i];
                if(adj != 0 && !visit[adj] && !select[adj]) {
                    visit[adj] = true;
                    queue.offer(adj);
                }
            }
        }

        //모두 방문 가능
        int visitCnt = 0;
        for( int i = 1; i<=N; i++) {
            if(visit[i]) visitCnt++;
        }
        if(visitCnt == N) {
            // 인구수 각자 계산 차이 도출
            int sumA = 0;
            int sumB = 0;

            for(int i=1; i<=N; i++) {
                if( select[i]) sumA += matrix[i][0];
                else sumB +=matrix[i][0];
            }

            min = Math.min(min, Math.abs(sumA-sumB));
        }
    }
}
