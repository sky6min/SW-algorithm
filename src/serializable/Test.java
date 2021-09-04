package serializable;

import java.io.*;

public class Test {
    // serializable 객체 직렬화
    public static void main(String[] args) throws Exception {
        MyClass mc = new MyClass(1,"2","3");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aaa.dat"));
        oos.writeObject(mc);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aaa.dat"));
        MyClass mc2 = (MyClass) ois.readObject();
        System.out.println(mc2);


    }
}


class MyClass implements Serializable {
    int i;
    String s;
    String ssn;

    public MyClass(int i, String s, String ssn) {
        this.i = i;
        this.s = s;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}