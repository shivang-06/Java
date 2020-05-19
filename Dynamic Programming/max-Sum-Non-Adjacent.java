/*Question
    1. You are given a number n, representing the count of elements.
2. You are given n numbers, representing n elements.
3. You are required to find the maximum sum of a subsequence with no adjacent elements.

                               
                               
                               
                               
Input Format
A number n
n1
n2
.. n number of elements
Output Format
A number representing the maximum sum of a subsequence with no adjacent elements.
Constraints
1 <= n <= 1000
-1000 <= n1, n2, .. n elements <= 1000
Sample Input
6
5
10
10
100
5
6
Sample Output
116*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int include = arr[0] < 0 ? 0 : arr[0]; //if first ele -ve put 0 else include first ele.
        int exclude = 0;

        for (int i = 1; i < n; i++) {
            int nInc = exclude + arr[i];
            int nExc = Math.max(include, exclude);
            include = nInc;
            exclude = nExc;
        }
        System.out.println(Math.max(include, exclude));

    }
}