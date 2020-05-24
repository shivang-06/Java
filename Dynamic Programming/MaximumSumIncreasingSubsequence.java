/*Question
 1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the sum of elements of the increasing subsequence with maximum sum for the array.
                               
Input Format
A number n
.. n more elements
Output Format
A number representing the sum of elements of the increasing subsequence with maximum sum for the array.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 100
Sample Input
10
10
22
9
33
21
50
41
60
80
1
Sample Output
255*/
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

        int omax = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Integer max = null;

            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (max == null || dp[j] > max) {
                        max = dp[j];
                    }
                }
            }

            if (max != null) {
                dp[i] = max + arr[i];
            } else {
                dp[i] = arr[i];
            }

            if (dp[i] > omax) {
                omax = dp[i];
            }
        }

        System.out.println(omax);
    }

}