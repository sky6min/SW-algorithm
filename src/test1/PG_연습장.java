package test1;


import java.util.*;

public class PG_연습장 {



    public static void main(String[] args) {
        int []fees = {180,5000,10,600};
        String []records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees, records);
    }

    static boolean[] visited = new boolean[10000];
    static String val[] = new String[10000];

    static int res[] = new int[10000];
    static int fin[] = new int[10000];

    static ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<records.length; i++) {
            char[] record = records[i].toCharArray();
            if(record[record.length-1] == 'N') {
                int a = Integer.parseInt(records[i].substring(6, 10));
                visited[a] = true;
                val[a] = records[i].substring(0,5);
            }else if(record[record.length-1] == 'T') {
                int b = Integer.parseInt(records[i].substring(6,10));
                int hour2 = Integer.parseInt(records[i].substring(0,2));
                int minute2 = Integer.parseInt(records[i].substring(3,5));

                int hour = Integer.parseInt(val[b].substring(0,2));
                int minute = Integer.parseInt(val[b].substring(3,5));


                System.out.print(b);
                System.out.println("시간 :" + hour + "," + "분 : " + minute);
                System.out.println("시간2 :" + hour2 + "," + "분2 : " + minute2);


                int total = (hour2 * 60 + minute2) - (hour * 60 + minute);
                res[b] += total;

                visited[b] = false;

            }
        }

        for(int i=0; i<10000; i++) {
            if(visited[i]) {
                System.out.println("i : " + i);

                int hour = Integer.parseInt(val[i].substring(0,2));
                int minute = Integer.parseInt(val[i].substring(3,5));

                int total = (23 * 60 + 59) - (hour * 60 + minute);

                System.out.println(i);
                res[i] += total;

                System.out.println(res[i]);


            }
        }
        for(int i=0; i<10000; i++) {
            if(res[i] - fees[0] < 0) {
                fin[i] += fees[1] + (int)  Math.ceil(0/fees[2]) * fees[3];
            }else {
                fin[i] += fees[1] + (int)  Math.ceil((res[i]-fees[0])/fees[2]) * fees[3];
            }
        }


        for(int i=0; i<10000; i++) {
            if(fin[i] != 0) {
                al.add(fin[i]);
            }
        }
        return al;
    }


}



