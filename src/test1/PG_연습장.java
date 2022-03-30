package test1;


import java.util.*;

public class PG_연습장 {


    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees, records);
    }

    static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

    static ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            String t = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            String time[] = t.split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);

            int total = hour * 60 + minute;

            if (map.containsKey(num)) {
                ArrayList<Integer> al = map.get(num);
                al.add(total);
                map.put(num, al);

            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(total);
                map.put(num, al);
            }

        }

        for (int carNum : map.keySet()) {
            ArrayList<Integer> al = map.get(carNum);
            if (al.size() % 2 == 1) {
                al.add(23 * 60 + 59);
            }
            int res = 0;
            for (int i = 0; i < al.size(); i = i + 2) {
                int start = al.get(i);
                int end = al.get(i + 1);
                res += end - start;

            }

            int result = fees[1] + (int) Math.ceil((double) (res - fees[0]) / fees[2]) + fees[3];
            answer.add(result);
        }

        return answer;
    }


}