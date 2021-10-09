package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_낚시왕_17143 {


    static int dx[] ={ 0, 0, 1,-1};  // 상 하 우 좌
    static int dy[] ={ 1,-1, 0, 0};
    static int R, C, M;
    static ArrayList<Shark> al = new ArrayList<Shark>();


    static int res;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());



        // 초기 설정
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            al.add(new Shark(r,c,s,d,z));

        }

        int cur = -1;
        res = 0;
        //
        while(cur < C ) {

            // 움직이고, 잡는다. al에 접근해서 움직이고 잡는 작업 수행.
            cur++;
            int min = Integer.MAX_VALUE;

            for(int i = 0; i<al.size(); i++) {
                if(al.get(i).c == cur) {
                    min = Math.min(min, al.get(i).r);
                }
            }
            System.out.println(al.size());
            for(int i = 0; i<al.size(); i++) {
                if(al.get(i).c == cur && al.get(i).r == min) {
                    res += min;
                    al.remove(i);
                }
            }
            System.out.println(al.size());
            // 상어 이동 & 같은 칸의 상어 잡아먹기 -> map 갱신
            for(int i = 0; i<al.size(); i++) {
                Shark sh = al.get(i);
                if(sh.z == -1) continue;

                // 상어 이동 & 잡아먹기 완료
                int nr = sh.r;
                int nc = sh.c;
                for(int j=0; j<sh.s; j++) {
                    nr +=  dy[sh.d];
                    nc +=  dx[sh.d];

                    if( nr < 0) {
                        sh.d = 0;
                        nr += (dy[sh.d]*2);
                    }else if( nr >= R) {
                        sh.d = 1;
                        nr += (dy[sh.d]*2);
                    }else if( nc < 0) {
                        sh.d = 2;
                        nc += (dx[sh.d]*2);
                    }else if (nc >= C) {
                        sh.d = 3;
                        nc += (dx[sh.d]*2);
                    }
                }

                // 잡아먹기
                for(int j=0; j<al.size(); j++) {
                    if(al.get(j).r == nr && al.get(j).c == nc) {
                        if(al.get(j).z == -1) continue;

                        if(al.get(j).z > sh.z) {
                            al.get(j).z += sh.z;
                            sh.z = -1;
                        }else{
                            sh.z += al.get(j).z;
                            al.get(j).z = -1;
                        }
                    }
                }

                // 값 갱신
                al.get(i).r = nr;
                al.get(i).c = nc;
                al.get(i).d = sh.d;
                al.get(i).z = sh.z;


            }

            // map 을 기준으로 arraylist 초기화  get.j == -1 이면 삭제
            for(int i=0; i<al.size(); i++) {
                if(al.get(i).z == -1) {
                    al.remove(i);
                }
            }

        }

        System.out.println(res);

    }


    static class Shark{
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
