package test1.신한;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_문자해독_1593ans {
    static int sAlpha[] = new int[26];
    static int bAlpha[] = new int[26];
    static int sAlpha2[] = new int[26];
    static int bAlpha2[] = new int[26];
    static char[] pattern;
    static char[] ary;
    static int g;
    static int s;
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        g = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        pattern = new char[g];
        ary = new char[s];
        pattern = br.readLine().toCharArray();
        ary = br.readLine().toCharArray();
        int from = 0;

        for(int i=0; i<g; i++) {
            if(pattern[i] > 90) {  // 소문자
                sAlpha[pattern[i] - 'a']++;

            }else{  // 대문자
                bAlpha[pattern[i] - 'A']++;
            }
        }
        int n = 0;
        for(int to=0; to<s; to++) {
            if(ary[to] > 90) {  // 소문자
                sAlpha2[ary[to] - 'a']++;
                n++;
            }else{
                bAlpha2[ary[to] - 'A']++;
                n++;
            }

            if(same()) {
                res++;
            }

            if(n == g) {
                if(ary[from] > 90) {  // 소문자
                    sAlpha2[ary[from] - 'a']--;
                }else{
                    bAlpha2[ary[from] - 'A']--;
                }
                from++;
                n--;
            }


        }

        System.out.println(res);
    }

    static boolean same() {
        for(int i=0; i<26; i++) {
            if(sAlpha[i] != sAlpha2[i]) {
                return false;
            }
            if(bAlpha[i] != bAlpha2[i]) {
                return false;
            }
        }
        return true;
    }
}
