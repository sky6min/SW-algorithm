package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_미생물격리_2382 {

    static int N, M, K;
    static int visited[][];
    static int visited_cnt[][][];
    static Node bugs[];
    static int flag;
    static int dx[] = {0, 0, 0, -1, 1};  // 상 하 좌 우
    static int dy[] = {0, -1, 1, 0, 0};

    // priority queue 이용해서 풀어야됨. 세 방향에서 합쳐질때 높은 순서로 넣어야 합쳐지고 비교하는 오류를 범하지 않음.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int res = 0;
            flag = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            bugs = new Node[K];
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                bugs[k] = new Node(col,row,cnt,dir);
            }

            // 알고리즘 M시간 동안

            for (int m = 0; m < M; m++) {
                // 어느 군집이 있는지 여부
                visited = new int[N][N];
                visited_cnt = new int[N][N][5];
                // 몇 개 있는지 맵도 따로 정의

                for (int k = 0; k < K; k++) {
                    flag = 0;
                    Node bug = bugs[k];
                    if(bug.cnt == 0) continue;

                    if(bug.x + dx[bug.dir] <= 0 || bug.x + dx[bug.dir] >= N-1 || bug.y + dy[bug.dir] <= 0 || bug.y + dy[bug.dir] >= N-1) {
                        bug.x = bug.x + dx[bug.dir];
                        bug.y = bug.y + dy[bug.dir];

                        bug.cnt = bug.cnt / 2;
                        if(bug.dir == 1) {
                            bug.dir = 2;
                        }else if(bug.dir == 2) {
                            bug.dir = 1;
                        }else if(bug.dir == 3) {
                            bug.dir = 4;
                        }else{
                            bug.dir = 3;
                        }
                        bugs[k] = bug;
                        continue;
                    }

                    // 군집 이동
                    // 겹친다
                    if(visited[bug.y+dy[bug.dir]][bug.x+dx[bug.dir]] != 0) {
                        int p = visited[bug.y+dy[bug.dir]][bug.x+dx[bug.dir]];

                        if(bugs[p].cnt > bugs[k].cnt) {
                            visited[bug.y+dy[bug.dir]][bug.x+dx[bug.dir]] = p;
                            bugs[p].cnt += bugs[k].cnt;
                            bugs[k].cnt = 0;
                        }else {
                            visited[bug.y+dy[bug.dir]][bug.x+dx[bug.dir]] = k;
                            bugs[k].x = bug.x+dx[bug.dir];
                            bugs[k].y = bug.y+dy[bug.dir];
                            bugs[k].cnt += bugs[p].cnt;
                            bugs[p].cnt = 0;
                        }

                    }else {
                        visited[bug.y+dy[bug.dir]][bug.x+dx[bug.dir]] = k;
                        bug.x = bug.x+dx[bug.dir];
                        bug.y = bug.y+dy[bug.dir];
                        bugs[k] = bug;
                    }
                }
            }
            for (int i = 0; i < K; i++) {
                res += bugs[i].cnt;
            }
            System.out.println(res);
        }
    }

    static class Node {
        int x;
        int y;
        int cnt;
        int dir;

        public Node(int x, int y, int cnt, int dir) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
    }
}
