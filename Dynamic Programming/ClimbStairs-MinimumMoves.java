/*Question
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you could jump to in a single move. 
You can of-course fewer number of steps in the move.
4. You are required to print the number of minimum moves in which you can reach the top of staircase.
Note -> If there is no path through the staircase print null.
                               
                               
Input Format
A number n
.. n more elements
Output Format
A number representing the number of ways to climb the stairs from 0 to top.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 20
Sample Input
10
1
1
1
4
9
8
1
1
10
1

Sample Output
5*/
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      Integer[] dp = new Integer[n];
      dp[n - 1] = 0;

      for (int i = n - 2; i >= 0; i--) {
         if (arr[i] > 0) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= arr[i] && i + j < arr.length; j++) {
               if(dp[i + j] != null){
                  min = Math.min(min, dp[i + j]);
               }
            }

            if(min != Integer.MAX_VALUE){
               dp[i] = min + 1;
            }
         }
      }

      System.out.println(dp[0]);
   }

}