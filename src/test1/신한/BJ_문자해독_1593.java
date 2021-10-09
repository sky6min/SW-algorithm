package test1.신한;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_문자해독_1593 {

    static int bAlpha[] = new int[26];
    static int sAlpha[] = new int[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pnum = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        for(int i=0; i<pnum; i++) {
            int ch = str.charAt(i);
            if(ch < 91) {   // 대문자면
                bAlpha[ch-'A']++;
            }
            else{
                sAlpha[ch-'a']++;
            }

        }

        int btemp[] = new int[26];
        int stemp[] = new int[26];

        int cnt = 0;
        int res = 0;
        String str2 = br.readLine();
        for(int i=0; i<num; i++) {
            int ch = str2.charAt(i);

            if(cnt == pnum) {
                int ch2 = str2.charAt(i-pnum+1);

                if(ch2 < 91) { // 대문자면
                    btemp[ch2-'A']--;
                }else{
                    stemp[ch2-'a']--;
                }
                cnt--;
                res++;
            }

            if(ch < 91) {   // 대문자면
                if(bAlpha[ch-'A'] == 0) {
                    Arrays.fill(btemp, 0);
                    Arrays.fill(stemp, 0);
                    cnt = 0;
                }
                else if(btemp[ch-'A'] > bAlpha[ch-'A']) {
                    i = i - pnum + 1;
                    btemp[ch-'A'] = btemp[ch-'A'] - 2;
                    while(str2.charAt(i) != ch) {
                        btemp[str2.charAt(i) - 'A']--;
                        cnt--;
                        i++;


                    }

                }

            }else {
                if(sAlpha[ch-'a'] == 0) {
                    Arrays.fill(btemp, 0);
                    Arrays.fill(stemp, 0);
                    cnt = 0;
                }
                else if(stemp[ch-'a'] > sAlpha[ch-'a']) {
                    i = i - pnum + 1;
                    stemp[ch-'a']= stemp[ch-'a'] - 2;
                    while(str2.charAt(i) != ch) {
                        stemp[str2.charAt(i) - 'a']--;
                        i++;
                        cnt--;
                    }

                }

            }


            if(ch < 91) {  // 대문자면
                btemp[ch-'A']++;
                cnt++;
            }else {
                stemp[ch-'a']++;
                cnt++;
            }
        }
        System.out.println(res);
    }
}
