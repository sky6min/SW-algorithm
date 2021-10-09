package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_키순서_5643 {

    static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            ArrayList<Integer> al[];
            ArrayList<Integer> als[];

            int cnt = N;
            al = new ArrayList[N+1];
            als = new ArrayList[N+1];

            for(int i=0; i<=N; i++) {
                al[i] = new ArrayList<Integer>();
            }

            for(int i=0; i<=N; i++) {
                als[i] = new ArrayList<Integer>();
            }

            for(int i=0; i<M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                al[from].add(to);
                als[to].add(from);
            }

            for(int i=1; i<=N; i++) {

                boolean visit[] = new boolean[N+1];

                // 부모찾기
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int now = queue.poll();
                    visit[now] = true;


                    for(int j=0; j<al[now].size(); j++) {
                        if(visit[j]) continue;

                        int a = al[now].get(j);
                        queue.offer(a);


                    }
                }

                // 자식찾기
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int now = queue.poll();
                    visit[now] = true;

                    for(int j=0; j<als[now].size(); j++) {
                        if(visit[j]) continue;

                        int a = als[now].get(j);

                        queue.offer(a);

                    }
                }

                for(int j=1; j<= N; j++) {
                    if(!visit[j]) {
                        cnt--;
                        break;
                    }
                }
            }

            System.out.println("#" + t + " " + cnt);
        }

    }
}
