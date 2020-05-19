/*Question
   1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
Note1 -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.

                               
                               
                               
Input Format
A number n
v1 v2 .. n number of elements
w1 w2 .. n number of elements
A number cap
Output Format
A number representing the maximum value that can be created in the bag without overflowing it's capacity
Constraints
1 <= n <= 20
0 <= v1, v2, .. n elements <= 50
0 < w1, w2, .. n elements <= 10
0 < cap <= 10
Sample Input
5
15 14 10 45 30
2 5 1 3 4
7
Sample Output
75*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] value = new int[n];
        for (int i = 0; i < value.length; i++) {
            value[i] = sc.nextInt();
        }
        int[] wt = new int[n];
        for (int i = 0; i < wt.length; i++) {
            wt[i] = sc.nextInt();
        }
        int cap = sc.nextInt();

        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i <= n; i++) { //current element
            for (int j = 1; j <= cap; j++) { //current capacity
                //Item not chosen 
                int maxProfit = dp[i - 1][j];
                //item chosen
                if (j - wt[i - 1] >=0){
                    maxProfit = Math.max(maxProfit,value[i-1]+dp[i-1][j-wt[i-1]]);
                }
                dp[i][j] = maxProfit;
            }
        }

    System.out.println(dp[n][cap]);
    }
}