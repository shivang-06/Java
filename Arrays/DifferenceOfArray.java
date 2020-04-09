/*Question
   1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. The two arrays represent digits of two numbers.
6. You are required to find the difference of two numbers represented by two arrays and print the
arrays. a2 - a1

Assumption - number represented by a2 is greater

                               
                               
                               
Input Format
A number n1
n1 number of elements line separated
A number n2
n2 number of elements line separated
Output Format
A number representing difference of two numbers (a2 - a1), represented by two arrays.
Constraints
1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10
number reresented by a1 is smaller than number represented by a2
Sample Input
3
2
6
7
4
1
0
0
0
Sample Output
7
3
3*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = sc.nextInt();
        }
        
        int n2 = sc.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = sc.nextInt();
        }
        
        int borrow = 0;
        
        int[] diffArr = new int[n2];
        
        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = diffArr.length - 1;
        while (k >= 0) {
            int iVal = 0;
            int diff = 0;
            if (i >= 0) {
                iVal = a1[i];
            }

            if (a2[j] - borrow >= iVal) {
                diff = a2[j] - iVal - borrow;
                borrow = 0;
            } else {
                diff = a2[j] - iVal - borrow + 10;
                borrow = 1;
            }

            diffArr[k] = diff;
            i--;
            j--;
            k--;
        }

        int flag = 0;
        for (int z = 0; z < diffArr.length; z++) {
            if (flag == 0 && diffArr[z] == 0) {
                continue;
            }
            flag = 1;
            System.out.println(diffArr[z]);
        }
    }

}