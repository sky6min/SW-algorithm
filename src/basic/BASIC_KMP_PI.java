package basic;

import java.util.Arrays;

public class BASIC_KMP_PI {

    public static void main(String[] args) {
        String pattern = "ABAABAB";
        System.out.println(Arrays.toString(getPI(pattern)));
    }

    static int[] getPI(String p) {
        int[] pi = new int[p.length()];
        char[] pArray = p.toCharArray();

        int j = 0;  // 접두사 index
        // 접미사 index i  <- for 문 안에서 계속 증가
        for (int i = 1; i < pArray.length; i++) {

            while( j>0 && pArray[i] != pArray[j] ) j = pi[j-1];   // 비교하는 두 문자가 일치하지 않으면 접두사 index 조정

            if( pArray[i] == pArray[j]) pi[i] = ++j;
        }
        return pi;
    }
}

/*
pi[0] = 0
pi[1] = 0
....
 i=1                 pi[1] = 0 그대로 변화 X
A B A A B A B
  A B A A B A B
 j=0

   i=2                 pi[2] = 1(++j)
A B A A B A B
    A B A A B A B
   j=0 => j=1
    *
A B A
*

     i=3             while : j = pi[j-1] = pi[0] = 0
A B A A B A B
    A B A A B A B
     j=1

     i=3             pi[3] = 1(++j)
A B A A B A B
      A B A A B A B
     j=0 => j=1

      *
A B A A
*

       i=4             pi[4] = 2(++j)
A B A A B A B
      A B A A B A B
       j=1 => j=2

         i=5             pi[5] = 3(++j)
A B A A B A B
      A B A A B A B
         j=2 => j=3

           i=6             while : j = pi[j-1] = pi[2] = 1
A B A A B A B
      A B A A B A B
           j=3

           i=6           pi[6] = 2
A B A A B A B
          A B A A B A B
           j=1
 */