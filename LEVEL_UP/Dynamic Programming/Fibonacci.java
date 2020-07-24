/*Question
1. You are given a number n.
2. You are required to print the nth element of fibonnaci sequence.
Note -> Notice precisely how we have defined the fibonnaci sequence
0th element -> 0
1st element -> 1
2nd element -> 1
3rd element -> 2
4th element -> 3
5th element -> 5
6th element -> 8
Input Format
A number n
Output Format
A number representing the nth element of fibonnaci sequence
Constraints
0 <= n <= 45
Sample Input
28
Sample Output
317811*/
import java.io.*;
import java.util.*;

public class Main {
updated 
  public static int fib_rec(int n) { // *****recursive approach*********
    if (n == 0 || n == 1) return n;

    int fibNm1 = fib_rec(n - 1);
    int fibNm2 = fib_rec(n - 2);

    return fibNm1 + fibNm2;
  }

  public static int fib_mem(int n, int dp[]) { //************** memoization approach**************
    if (n == 0 || n == 1) return dp[n] = n; //in this statement first assignment is done then return is done.
    if (dp[n] != 0) {
      //answer already exist
      return dp[n];
    }
    int fibNm1 = fib_mem(n - 1, dp);
    int fibNm2 = fib_mem(n - 2, dp);
    return dp[n] = (fibNm1 + fibNm2); // First assignment will be done then return will be performed.
  }

  public static int fib_tab(int n) { //********Tabulation approach**********
    int[] dp = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      if (i == 1 || i == 0) {
        dp[i] = i;
        continue; //to continue for loop if answer already exist for current iteration.
      }
      int fibNm1 = dp[i - 1];
      int fibNm2 = dp[i - 2];

      dp[i] = (fibNm1 + fibNm2);
    }
    return dp[n];
  }

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    // System.out.println(fib_rec(n));
    System.out.println(fib_mem(n, new int[n + 1]));
  }
}
