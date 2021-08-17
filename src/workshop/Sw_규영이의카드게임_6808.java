package workshop;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw_규영이의카드게임_6808 {

    static int card[];

    static int srcCard[];
    static int tgtCard[];
    static boolean isSelected[];
    static boolean isSelected2[];

    static int COUNT;
    static int mCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t <=T; t++) {
            COUNT = 0;
            mCount = 0;
            card = new int[9];
            srcCard = new int[9];
            //tgtCard = new int[9];
            isSelected = new boolean[9];
            isSelected2 = new boolean[19];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<9; i++) {
                card[i] = Integer.parseInt(st.nextToken());
                isSelected2[card[i]] = true;
            }

            int idx = 0;
            for(int i=1; i<=18; i++) {
                if(isSelected2[i] != true) {
                    srcCard[idx++] = i;
                }
            }

            perm(0,0, 0); // Index --------> N

            System.out.println("#" + t + " " + COUNT + " " + mCount);
        }


    }

    static void perm(int tgtIdx, int guSum, int inSum) {
        if(tgtIdx == 9) {
/*            int mScore=0;
            int wScore=0;
            for(int i=0; i<9; i++) {
                if(card[i] > tgtCard[i]) {
                    mScore = mScore + card[i] + tgtCard[i];
                }else {
                    wScore = wScore + card[i] + tgtCard[i];
                }
            }
            if(mScore > wScore) {
                COUNT++;
            } else if (mScore < wScore) {
                mCount++;
            }*/
            // 작업

            if(guSum > inSum) COUNT++;
            else if(guSum < inSum) mCount++;
            return;
        }

        for(int i=0; i<9; i++) {
            if(isSelected[i]) continue;


            //tgtCard[tgtIdx] = srcCard[i];

            isSelected[i] = true;

            if( card[tgtIdx] > srcCard[i]) {  // 내가 선택한 srcCard[i]와 규영이 카드를 비교
                perm(tgtIdx + 1, guSum+card[tgtIdx]+ srcCard[i], inSum);

            }else {
                perm(tgtIdx + 1, guSum, inSum + card[tgtIdx] + srcCard[i]);
            }
            isSelected[i] = false;

        }
    }
}
