package livecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoomTest {

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {    // 음수(내가 작다):오름차순,  양수(내가 크다): 내림차순,   0(둘이 같다): 오름차순

            int value = this.end - o.end;
            if(value != 0) return value; // 종료시간이 다르면

            return this.start - o.start;   // 종료시간이 같다면 시작시간이 빠른 순서로.
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 회의 개수

        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }

        for( Meeting meeting : getSchedule(meetings)) {
            System.out.println(meeting);
        }

    }

    static ArrayList<Meeting> getSchedule(Meeting[] meetings) {

        ArrayList<Meeting> list = new ArrayList<Meeting>();

        Arrays.sort(meetings); // 종료시간 기준 오름차순 정렬
        list.add(meetings[0]); // 첫회의 추가.

        for(int i=1,size = meetings.length; i < size; i++) {
            if(list.get(list.size()-1).end <= meetings[i].start) {   // 직전회의 끝나는 시간과 지금 회의 시작 시간을 비교
                list.add(meetings[i]);
            }
        }
        return list;

    }
}
