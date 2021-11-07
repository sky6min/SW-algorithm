package test1.라인;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class line_재학생_1 {

    static ArrayList<Integer> src = new ArrayList<Integer>();
    static int K, result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; st.hasMoreTokens(); i++) {
            src.add(Integer.parseInt(st.nextToken()));
        }

        int start = 0;
        int end = 0;
        // 0 1 0 0 1 1 0  초기 start, end 값 할당
        int cnt = 0;
        for(int i=0; i<src.size(); i++) {
            if(cnt == 2) break;

            if(src.get(i) == 1) {
                if(start == 0) {
                    start = i;
                    cnt++;
                }else {
                    end = i;
                    cnt++;
                }
            }
        }
        System.out.println(start);
        System.out.println(end);

        int endpt = 0;
        for(int i=src.size()-1; i>=0; i--) {
            if(src.get(i) == 1) {
                endpt = i;
                break;
            }
        }
        System.out.println(endpt);
        boolean cont = true;
        int scnt = 0;
        int ecnt = 0;
        while(cont) {

            scnt = 1;
            for(int i=start-1; i>=0; i--) {
                if(src.get(i) == 1) {
                    break;
                }
                scnt++;
            }

            ecnt = 1;
            for(int i=end+1; i<src.size(); i++) {
                if(src.get(i) == 1) {

                    start = end;
                    end = i;
                    break;
                }
                ecnt++;
                if(i == src.size()-1) {
                    cont = false;
                }
            }

            result = result + (scnt * ecnt);

        }

        System.out.println(result);
    }


}
