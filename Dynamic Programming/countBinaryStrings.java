/*Question
    1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.

                               
                               
                               
                               
Input Format
A number n
Output Format
A number representing the number of binary strings of length n with no consecutive 0's.

Constraints
0 < n <= 45
Sample Input
6
Sample Output
21*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

            int[][] dp = new int[2][n+1];

            //base case
            dp[0][1] = 1;
            dp[1][1] = 1;

            for (int col = 2; col <= n; col++) {
                dp[0][col] = dp[1][col - 1]; //col length -0 pe end hone wali strings

                dp[1][col] = dp[0][col - 1] + dp[1][col - 1];//col length -1 pe end hone wali strings
            }
            System.out.println(dp[0][n] + dp[1][n]);
        }

    //     //2nd Method
    //     int one = 1;
    //     int zero = 1;
    //     for (int cl = 2; cl <= n; cl++) {
    //         int nZero = one; //new zero
    //         int nOne = zero + one; //new one
    //         one = nOne;
    //         zero = nZero;
    //     }
    //     System.out.println(one + zero);
    // }
}