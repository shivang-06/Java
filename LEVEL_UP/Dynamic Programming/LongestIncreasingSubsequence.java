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
1
64

Sample Output
1*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1;i<arr.length;i++){
            int max = 0;
            for(int j = i-1;j>=0;j--){
                if(arr[i] > arr[j] && dp[j]>max){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<dp.length;i++){
            if(ans < dp[i]){
                ans = dp[i];
            }
        }
        System.out.println(ans);
    }

}