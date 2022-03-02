package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_오픈채팅방_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] example = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        sol.solution(example);
    }

    static class Solution {
        public ArrayList<String> solution(String[] record) {
            HashMap<String,String> map = new HashMap<>();
            ArrayList<String> answer = new ArrayList<>();

            for(int i = 0; i < record.length; i++){
                StringTokenizer st = new StringTokenizer(record[i]);

                String behavior = st.nextToken();
                String id = st.nextToken();
                System.out.println("1");
                if(behavior.equals("Leave")) continue;
                System.out.println("2");
                String name = st.nextToken();
                map.replace(id, name);
            }

            for(int i = 0; i< record.length;i++){
                StringTokenizer st = new StringTokenizer(record[i]);
                String behavior = st.nextToken();
                String id = st.nextToken();
                if(behavior.equals("Enter")){
                    System.out.println("3");
                    answer.add(map.get(id)+"님이 들어오셨습니다.");
                }else if(behavior.equals("Leave")){
                    System.out.println("4");
                    answer.add(map.get(id)+"님이 나가셨습니다.");
                }
            }
            return answer;

        }



    }
}
