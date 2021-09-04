package singleton;

public class Test {

    public static void main(String[] args) {
        MyClass mc = MyClass.getInstance();
        int[] arr = mc.getArray();
    }
}


class MyClass{
    private int[] array;
    static private MyClass instance = new MyClass();
    private MyClass() {
        this.array = new int[5];
    }

    static public MyClass getInstance() {
        return instance;
    }

    public int[] getArray() {
        return array;
    }
}