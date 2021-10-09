package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_게리맨더링_17471 {
    static int N;
    static int area[];
    static ArrayList<Integer> al[];
    static boolean selected[];
    static boolean visited1[];
    static boolean visited2[];
    static int area1 = 0;
    static int area2 = 0;
    static int res = Integer.MAX_VALUE;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N+1];
        al = new ArrayList[N+1];
        selected = new boolean[N];
        visited1 = new boolean[N+1];
        visited2 = new boolean[N+1];
        for(int i=0; i<=N; i++) {
            al[i] = new ArrayList<Integer>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            area[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j=0; j<k; j++) {
                al[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        subset(0);
        System.out.println((res == Integer.MAX_VALUE) ? -1:res);
    }

    static void subset(int srcIdx) {
        //기저 조건
        if(srcIdx == N) {
            area1 = Integer.MAX_VALUE;
            area2 = 0;
            // complete code!!
            // 부분집합이 하나 완성!!
            search();
            res = Math.min(res, Math.abs(area1-area2));
            return;
        }

        // 선택
        selected[srcIdx] = true;
        subset(srcIdx+1);

        // 비선택
        selected[srcIdx] = false;
        subset(srcIdx+1);
    }

    static void search() {
        // 구역 1
        int start = 0;
        for(int i=0; i<N; i++) {
            if(selected[i]) {
                start = i+1;
                break;
            }
        }
        if(start == -1) return;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i=0; i<al[now].size(); i++) {
                if(selected[al[now].get(i)-1] && !visited1[al[now].get(i)]) {    // 같은 구역이라면 다음 연관관계 & visited에 추가
                    visited1[al[now].get(i)] = true;
                    queue.offer(al[now].get(i));
                }
            }
        }
        for(int i=1; i<N+1; i++) {
            if(selected[i-1]) {
                if(!visited1[i]) {
                    return;
                }
            }
        }
        // 구역 1
        int start2 = -1;
        for(int i=0; i<N; i++) {
            if(!selected[i]) {
                start2 = i+1;
                break;
            }
        }
        if(start2 == -1) return;
        queue.offer(start2);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i=0; i<al[now].size(); i++) {
                if(!selected[al[now].get(i)-1] && !visited2[al[now].get(i)]) {    // 같은 구역이라면 다음 연관관계 & visited에 추가
                    visited2[al[now].get(i)] = true;
                    queue.offer(al[now].get(i));
                }
            }
        }
        for(int i=1; i<N+1; i++) {
            if(!selected[i-1]) {
                if(!visited2[i]) {
                    return;
                }
            }
        }
        area1 = 0;
        area2 = 0;
        for(int i=1; i<=N; i++) {
            if(selected[i-1]) {
                area1 += area[i];
            }else {
                area2 += area[i];
            }
        }
    }
}
