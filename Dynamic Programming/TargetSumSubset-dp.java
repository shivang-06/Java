/*Question
    1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add upto "tar" or not.

                               
                               
                               
                               
Input Format
A number n
n1
n2
.. n number of elements
A number tar
Output Format
true or false as required
Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= tar <= 50
Sample Input
5
4
2
7
1
3
10
Sample Output
true*/

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
        int tar = sc.nextInt();
        boolean[][] dp = new boolean[n + 1][tar + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= tar; j++) {
                //element refused to contribute
                dp[i][j] = dp[i - 1][j];

                //element contributed
                if (dp[i][j] == false && j - arr[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        System.out.println(dp[n][tar]);
    }
}