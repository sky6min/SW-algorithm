package test1;

import java.util.*;

public class PG_튜플 {

    public static void main(String[] args) {
        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }

    static Queue<Character> queue = new LinkedList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();

        String str = s.substring(1,s.length()-1);
        char[] temp = str.toCharArray();

        for(int i=0; i< temp.length; i++) {
            queue.offer(temp[i]);
        }
        int flag = 0;
        int cnt = 1;
        String st = "";
        ArrayList<Integer> al = new ArrayList<>();
        while(!queue.isEmpty()) {
            char a = queue.poll();
            if(a == '{') {
                flag = 1;
                al = new ArrayList<>();
                cnt = 0;
            }

            if(a == ',') {
                cnt = cnt + 1;
                if(flag == 1) {
                    st = st + ",";
                }
            }

            if(a == '}') {
                flag = 0;
                System.out.println(st);
                char[] element = st.toCharArray();
                String s1 = "";
                for(int i=0; i< element.length; i++) {

                    if(element.length == 1) {
                        al.add(element[0] - '0');
                    }
                    if(i == element.length-1 && s1 == "") {
                        al.add(element[element.length-1] - '0');
                        continue;
                    }
                    if(element[i] == ',' || i == element.length-1) {
                        al.add(Integer.parseInt(s1));
                        s1 = "";
                    }else{
                        s1 = s1 + element[i];
                    }
                }

                Node node = new Node();
                node.al = al;
                node.cnt = cnt;
                System.out.println(node.cnt);
                pq.offer(node);
                st = "";
            }

            if( a == '0' || a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8' || a == '9' ) {
                st = st + a;
            }

        }
        boolean visited[] = new boolean[100000+1];

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            for(int i=0; i<node.al.size(); i++) {
                int num = node.al.get(i);
                if(visited[num]) continue;
                answer.add(num);
                visited[num] = true;
            }

        }
        return answer;
    }

    static class Node implements Comparable<Node> {
        ArrayList<Integer> al;
        int cnt;


        @Override
        public int compareTo(Node o) {
            return o.cnt <= this.cnt ? 1: -1;
        }
    }
}
