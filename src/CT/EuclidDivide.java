package CT;

public class EuclidDivide {

    public static void main(String[] args) {
        eeuc(1071, 1029);
        System.out.println(gcd(1071, 1029));
    }

    private static int gcd(int a, int b) {
        if(a == 0) return b;
        else if(b == 0) return a;
        else if(a>b) return gcd(a%b, b);
        else if(a<b) return gcd(a, b%a);
        else return a;
    }

    private static void eeuc(int a, int b) {
        int r0 = a;
        int r1 = b;
        int s0 = 1;
        int s1 = 0;
        int t0 = 0;
        int t1 = 1;
        int temp = 0;
        int q = 0;
        while(r1>0) {
            q = r0/r1;
            temp = r0;
            r0 = r1;
            r1 = temp - r1* q;
            temp = s0;
            s0 = s1;
            s1= temp - s1*q;
            temp = t0;
            t0 = t1;
            t1 = temp-t1*q;
        }

        System.out.printf("(%d)*(%d)+(%d)*(%d)=%d \n",a,s0,b,t0,a*s0+b*t0);
    }
}
