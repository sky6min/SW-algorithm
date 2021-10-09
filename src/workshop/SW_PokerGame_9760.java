package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_PokerGame_9760 {

    static int T;
    static char[] suit = {'S', 'D', 'H', 'C'};
    static char[] rank = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
    static int[] suitCnt, rankCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t= 1; t<= T; t++) {
            suitCnt = new int[4];
            rankCnt = new int[14];  // 0 dummy  rankCnt[3] = 2    ->    3이라는 숫자가 2번 나왔다.

            String[] card = br.readLine().split(" ");

            for(int i=0; i<5; i++) {
                for (int j = 0; j < 4; j++) {
                    if(suit[j] == card[i].charAt(0)) suitCnt[j]++;    // 각 카드마다 이니셜을 방문하여 몇개가 채워지는지 체크
                }
                for (int j = 0; j < 13; j++) {
                    if(rank[j] == card[i].charAt(0)) rankCnt[j]++;    // 각 카드마다 이니셜을 방문하여 몇개가 채워지는지 체크
                }
            }

        }
    }

}
