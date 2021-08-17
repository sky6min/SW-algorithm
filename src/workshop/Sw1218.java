package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Sw1218 {

    static char[] op = {'(','[','{','<'};
    static char[] cl = {')',']','}','>'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ary;
        int T = Integer.parseInt(br.readLine());
        int num;
        for(int t=0; t<T; t++) {
            Stack<Character> s = new Stack<Character>();
            int stat = 1;
            num = Integer.parseInt(br.readLine());
            ary = new char[num];
            ary = br.readLine().toCharArray();

            for(int i=0; i<num; i++) {
                if (stat == 0) {
                    break;
                }
                if (ary[i] == '(' || ary[i] == '<' || ary[i] == '[' || ary[i] == '{') {
                    s.push(ary[i]);
                } else {
                    for (int j = 0; j < 4; j++) {
                        if (cl[j] == ary[i]) {
                            if (op[j] == s.peek()) {
                                s.pop();
                            } else {
                                stat = 0;
                            }
                        }
                    }
                }
            }
            if(!s.empty()) stat = 0;
            System.out.println("#" + t + " " + stat);
        }
    }
}
