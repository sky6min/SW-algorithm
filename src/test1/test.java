package test1;

import java.util.ArrayList;

public class test {
    static ArrayList<Node> al = new ArrayList<Node>();
    public static void main(String[] args) {
        Node n = new Node(1,2);

        al.add(n);
        System.out.println(al.get(0).x + "," + al.get(0).y);
        al.get(0).x = 4;
        al.get(0).y = 5;

        System.out.println(al.get(0).x + "," + al.get(0).y);

    }


    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
