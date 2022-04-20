package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_dfs스페셜저지_16964 {

    static int N;
    static ArrayList<ArrayList> tree;
    static String[] dfs;
    static boolean[] visited;
    static boolean flag = false;
    static int level = 1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정점의 수
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        // 트리의 정보 N-1
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList());
        }
        for (int i = 0; i < N - 1; i++) {
            String[] temp = br.readLine().split(" ");
            tree.get(Integer.parseInt(temp[0])).add(Integer.parseInt(temp[1]));
            tree.get(Integer.parseInt(temp[1])).add(Integer.parseInt(temp[0]));
        }
        dfs = br.readLine().split(" ");
        sj(Integer.parseInt(dfs[0]));
        int ret = flag? 1:0;
        System.out.println(ret);
    }

    public static int sj(int i){
        if (level == N) {
            flag = true;
            return 1;
        }
        int target = Integer.parseInt(dfs[level]);
        visited[i] = true;
        if(tree.get(i).contains(target)) {
            if (!visited[target]) {
                level++;
                sj(target);
            }
        }
        if(i!=Integer.parseInt(dfs[0])) sj(Integer.parseInt(dfs[0]));
        return 0;
    }
}
