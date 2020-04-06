/*Question
   1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to find the span of input. Span is defined as difference of maximum value and minimum value.
                               
                               
                               
Input Format
A number n
n1
n2
.. n number of elements
Output Format
A number representing max - min
Constraints
1 <= n <= 10^4
0 <= n1, n2, .. n elements <= 10 ^9
Sample Input
6
15
30
40
4
11
9
Sample Output
36*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = sc.nextInt();
        // }
        // int min = arr[0];
        // int max = arr[0];
        // for(int i = 0; i<arr.length;i++){
        //     if(arr[i]<min){
        //         min = arr[i];
        //     }else if(arr[i]>max){
        //         max = arr[i];
        //     }
        // }
        // int sapn = max-min;
        // System.out.println(span);

        //Approach 2 - with single loop
        int n = sc.nextInt();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        // System.out.println(min);
        int max = Integer.MIN_VALUE;
        // System.out.println(max);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            
            if (min>arr[i]) {
                min = arr[i];
            } else if (max < arr[i]) {
                max = arr[i];
            }
        }
        int span = max - min;
        System.out.println(span);
    }

}