package test1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PG_다단계칫솔판매 {


    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};


        solution(enroll, referral, seller, amount);
    }




    static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length+1];
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("-",0);
        int N = enroll.length+1;
        int parents[] = new int[N];
        for(int i=0; i<enroll.length; i++) {
            hm.put(enroll[i], i+1);
        }

        for(int i=0; i< referral.length; i++) {
            int a = hm.get(referral[i]); // 꼬드긴 사람
            int b = hm.get(enroll[i]);  // 꼬드김 당한 사람

            parents[b] = a;
        }



        for(int i=0; i< seller.length; i++) {
            int num = hm.get(seller[i]);
            int earn = 100*amount[i];
            while(earn >= 1){
                int money = earn/10;
                //int money = (int)Math.round(0.1*earn)
                answer[num] += earn - money;
                earn = money;
                num = parents[num];
                if(num == 0) break;
            }
        }

        int[] ans = new int[enroll.length];

        for(int i=0; i< ans.length; i++) {
            ans[i] = answer[i+1];

        }

        return ans;
    }



}