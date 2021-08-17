package workshop;

import java.util.ArrayList;
import java.util.List;

public class bj_캐슬디펜스_17135ans {

    static int N, M, D, max;
    static int[][] map; // 최초 상태  궁사의 상태가 바뀌면 다시 호출받아서 초기화, 창현이 형은 arraylist temp를 만들어서 사용.
    static int[] archer = new int[3]; // 궁사의 x 좌표
    static List<Enemy> enemy = new ArrayList<Enemy>();

    public static void main(String[] args) {


        // 태케 입력
        // map 배열도 완성

        comb(0, 0);
        System.out.println(max);
    }

    // 조합이 완성되면 호출
    static void check() {
        // 초기화
        // enemy array list 만들어준다

        // 시뮬레이션 시작
        while(true) {
            // 궁사 3명이 각각
            // for : 1번 궁사, 2번 ....
                // 적에 댛나 2차 자료구조 구성 (pqueue)
                // for 적 하나 하나에 대해서
                // 궁사 1번 에 위치 array list  에 있는 적들과의 거리를 따지면서 D 안에 들어오는 적은 pqueue 에 담는다.
                    // 적 하나에 대해서 현재 궁사와의 거리를 계산 - 그 거리가 D 이하( 사정거리) pqueue 에 담는다.

                // end for /./ pqueue에 담았다. (사정거리 안에 드는 적들은)

                // pqueue에 적이 있으면 한 녀석을 꺼내서 dead = true;
            // end for : 궁사

            // array list 정리
            // 적이 모두 사라지면 arraylist 에 적이 하나도 없으면 ...
            // break
        }
    }

    static void comb(int srcIdx, int tgtIdx) {


    }

    static class Enemy{
        int y, x, d; // 궁수와의 거리
        boolean dead; // 사망 여부

        public Enemy(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
