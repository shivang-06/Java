/*Question
 1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest increasing subsequence of array.
                               
Input Format
A number n
.. n more elements
Output Format
A number representing the length of longest increasing subsequence of array.
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
6*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int maxLen = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] > maxLen) {
                    maxLen = dp[j];
                }
            }
            dp[i] = maxLen + 1;
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ans < dp[i]) {
                ans = dp[i];
            }
        }
        System.out.println(ans);
    }


}