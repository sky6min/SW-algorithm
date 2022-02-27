package test1;

public class PG_양궁대회 {
    static int[] tgt;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] answer = {};
    static int[] apeach;
    public static void main(String[] args) {
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        solution(5, info);


    }

    static public int[] solution(int n, int[] info) {

        tgt = new int[n];
        apeach = info.clone();
        // info :  어피치의 과녁 정보
        N = n;
        comb(0,0);
        // answer : 라이언의 answer 정보

        // 중복 조합
        // 중복 조합에서 tgtIdx == n이면
        // 최대값 & 가장 작은 값 구하기
        if(answer.length == 0) {
            int[] ans = new int[1];
            ans[0] = -1;
            return ans;
        }
        return answer;
    }

    static void comb(int srcIdx, int tgtIdx) {
        // 기저조건
        if(tgtIdx == N) {
            // 라이언의 과녘 정보 target[] 저장.
            int[] target = new int[11];
            for(int i=0; i<N; i++) {
                target[tgt[i]]++;
            }

            int lion = 0;
            int peach = 0;
            // 라이언과 어피치 과녘 점수 계산
            for(int i=0; i<11; i++) {
                if(target[i] <= apeach[i] && apeach[i] != 0) {  // 어피치가 이길 경우
                    peach= peach + 10-i;
                }else if(target[i] != 0){  // 라이언이 이길 경우
                    lion= lion + 10-i;
                }
            }

            // 라이언이 어피치보다 점수가 높을 경우
            if(lion>peach) {
                System.out.println("라이언 점수 : " + lion);
                System.out.println("어피치 점수 : " + peach);
                // 라이언- 어피치의 점수 격차가 같을 때
                if(max == lion-peach) {
                    for(int i=10; i>= 0; i--) {
                        if(answer[i] > target[i]) {

                            break;
                        }else if(answer[i] < target[i]) {
                            answer = target.clone();
                            break;
                        }
                    }
                    // 최소 점수가 작은게 정답.

                }
                // 최대 격차일 때
                if(max < lion-peach) {
                    // 최대 격차 갱신
                    max = Math.max(max,lion-peach);
                    answer = target.clone();
                }
            }
            return;
        }

        if(srcIdx == 11) {
            return;
        }

        tgt[tgtIdx] = srcIdx;

        comb(srcIdx, tgtIdx+1);

        comb(srcIdx+1, tgtIdx);

    }
}
