package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_Z_1074 {

    static int r, c, res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken())+1;
        c = Integer.parseInt(st.nextToken())+1;
        int cnt = 0;
        recur(0,0 ,(int) Math.pow(2, N) , (int) Math.pow(2, N), cnt);
        System.out.println(res);
    }

    static void recur(int ymin, int xmin, int ymax, int xmax, int cnt) {
        if(ymax == r && xmax == c) {
            res = cnt;
            return;
        }

        int temp = ((ymax-ymin) * (xmax-xmin))/4;

        if(r<=(ymin+ymax)/2 && c<=(xmin+xmax)/2) {
            cnt = cnt;
            recur(ymin,xmin,(ymin+ymax)/2,(xmin+xmax)/2,cnt);

        }else if(r<=(ymin+ymax)/2 && c>=(xmin+xmax)/2) {
            cnt = (temp*1) + cnt;
            recur(ymin,(xmin+xmax)/2,(ymin+ymax)/2,xmax,cnt);

        }else if(r>=(ymin+ymax)/2 && c<=(xmin+xmax)/2) {
            cnt = (temp*2) + cnt;
            recur((ymin+ymax)/2, xmin, ymax, (xmin+xmax)/2, cnt);

        }else if(r>=(ymin+ymax)/2 && c>=(xmin+xmax)/2) {
            cnt = (temp*3) + cnt;
            recur((ymin+ymax)/2,(xmin+xmax)/2,ymax,xmax, cnt);

        }
        return;
        //
    }
}
