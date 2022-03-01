package test1;

import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_오픈채팅방 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] example = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        sol.solution(example);
    }

    static class Solution {
        public String[] solution(String[] record) {
            String[] answer = new String[record.length];
            // uid, 닉네임
            HashMap<String, String> map = new HashMap<String, String>();

            // hashMap에 값을 저장하는 과정.
            for(int i=0; i<record.length; i++) {
                StringTokenizer st = new StringTokenizer(record[i]);
                String command = st.nextToken();
                if(command.equals("Enter")) {
                    String uid = st.nextToken();
                    String nickName = st.nextToken();
                    map.put(uid, nickName);
                }else if(command.equals("Change")) {
                    String uid = st.nextToken();
                    String nickName = st.nextToken();
                    map.put(uid, nickName);
                }
            }

            // result를 생성하는 과정. enter, leave 만 읽어서 map.get("") +님이 +
            int res = 0;
            for(int i=0; i<record.length; i++) {
                StringTokenizer st = new StringTokenizer(record[i]);
                String command = st.nextToken();
                if(command.equals("Enter")) {
                    String uid = st.nextToken();
                    String nickName = st.nextToken();
                    answer[res++] = map.get(uid) + "님이 들어왔습니다.";
                }else if(command.equals("Leave")) {
                    String uid = st.nextToken();
                    answer[res++] = map.get(uid) + "님이 나갔습니다.";

                }
            }

            return answer;
        }
    }
}
