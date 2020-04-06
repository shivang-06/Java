/*Question
  1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. The two arrays represent digits of two numbers.
6. You are required to add the numbers represented by two arrays and print the
arrays
                               
                               
Input Format
A number n1
n1 number of elements line separated
A number n2
n2 number of elements line separated
Output Format
A number representing sum of two numbers, represented by two arrays.
Constraints
1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10
Sample Input
5
3
1
0
7
5
6
1
1
1
1
1
1
Sample Output
1
4
2
1
8
6*/

import java.util.*;

public class SumofTwoARray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] sum = new int[n1>n2? n1 : n2];
        int i = n1 - 1;
        int j = n2 - 1;
        int k = sum.length-1;
        int carry = 0;
        while(k>=0){
            int value = carry;
            if(i>=0){
                value += arr1[i];
            }
            if(j>=0){
                value += arr2[j];
            }
            carry = value / 10;
            value = value%10;
            sum[k] = value;
            i--;
            j--;
            k--;
            
        }
        if(carry !=0){
            System.out.println(carry);
        }
        for(int f = 0 ; f<sum.length;f++){
            System.out.println(sum[f]);
        }

            
    }

}