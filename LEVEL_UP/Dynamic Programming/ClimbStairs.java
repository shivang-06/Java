/*Question
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
3. You are required to print the number of different paths via which you can climb to the top.

                               
                               
                               
Input Format
A number n
Output Format
A number representing the number of ways to climb the stairs from 0 to top.
Constraints
0 <= n <= 20
Sample Input
7
Sample Output
44*/
import java.io.*;
import java.util.*;

public class Main {

    public static int cst_rec(int n) {
        //return number of ways climb n stairs
        if (n < 0) return 0;
        if (n == 0) return 1;
        int tways = 0;
        tways += cst_rec(n - 1); //1-len   
        tways += cst_rec(n - 2); // 2-len
        tways += cst_rec(n - 3); //3-len
        return tways;
    }
    public static int cst_mem(int n, int[] dp) {
        if (n == 0) return dp[n] = 1;
        if (dp[n] != 0) {
            return dp[n];
        }
        int tways = 0;
        tways += (n - 1 >= 0) ? cst_mem(n - 1, dp) : 0;
        tways += (n - 2 >= 0) ? cst_mem(n - 2, dp) : 0;
        tways += (n - 3 >= 0) ? cst_mem(n - 3, dp) : 0;
        return dp[n] = tways;

    }
    public static int cst_tab(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {

            if (i == 0) {
                dp[i] = 1;
                continue;
            }
            
            int tways = 0;
            tways += (i - 1 >= 0) ? dp[i-1] : 0;
            tways += (i - 2 >= 0) ? dp[i-2] : 0;
            tways += (i - 3 >= 0) ? dp[i-3] : 0;
            dp[i] = tways;
        }
        return dp[n];
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(cst_tab(n));
        // System.out.println(cst_mem(n, new int[n + 1]));
    }

}