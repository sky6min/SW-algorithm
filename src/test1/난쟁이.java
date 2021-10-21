package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 난쟁이{
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int res = 0;
    static int[] arr= new int[9];
    static int[] ans = new int[7];
    static void input(){
        for(int i=0;i<9;i++){
            arr[i] = sc.nextInt();
        }
    }
    static void pro(int k,int value,int idx){
        if(k==7){
            if(value==100){
                for(int i=0; i<7;i++){
                    sb.append(ans[i]);
                    if(i!=6) sb.append('\n');
                }
                res++;
            }
        }else {
            for(int cand=idx; cand<9;cand++){
                ans[k] = arr[cand];
                pro(k+1,value+ans[k],cand+1);
                if(res == 1) return;
                ans[k] = 0;

            }
        }

    }
    public static void main(String[] args) {
        input();
        Arrays.sort(arr);
        pro(0,0,0);
        System.out.print(sb.toString());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null||!st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}