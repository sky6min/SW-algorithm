package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

// nullpointException, ArrayOutofBoundsException 서술 및 설명 문제 나옴!
// equals() toString() 오버라이딩에 대한 문제
public class Test {

    public static void main(String[] args) {
        MyClassManager manager = new MyClassManager();
        SubClass sc = new SubClass();

        for(MyClass mc: manager.getList()) {
            System.out.println(mc);
        }

        Collections.sort(manager.getList());
        for(MyClass mc: manager.getList()) {
            System.out.println(mc);
        }
        Collections.sort(manager.getList(), (mc1, mc2) -> mc1.str.compareTo(mc2.str));
    }
}

// 클래스들 비교할때 equals 오버라이딩 하는 방법
/*String s1 = new String("Hello")
  String s2 = new String("Hello")
  s1 == s2 false
  s1.equals(s2) true

  md1.equals(md2) == true가 되는 클래스 오버라이딩
  */
class SubClass extends MyClass{

    public SubClass() {
        super();
    }


}

class MyClass implements Comparable<MyClass>{
    int i;
    String str;



    @Override
    public int hashCode() {
        return Objects.hash(i, str);
    }

    public MyClass() {

    }


    public MyClass(int i, String str) {
        this.i = i;
        this.str = str;
    }

    @Override
    public int compareTo(MyClass o) {
        return this.str.compareTo(o.str);
        //return this.i - o.i;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "i=" + i +
                ", str='" + str + '\'' +
                '}';
    }
}

class MyClassManager {

    private ArrayList<MyClass> al = new ArrayList<>();
    public ArrayList<MyClass> getList() {
        return this.al;
    }

    public MyClassManager() {
        al.add(new MyClass(3, "222"));
        al.add(new MyClass(1, "111"));
        al.add(new MyClass(2, "333"));
    }


}