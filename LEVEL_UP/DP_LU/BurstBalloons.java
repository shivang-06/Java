/*Question
1. You are given an array(arr) of length N which represents N number of balloons.
2. Each balloon is painted with a number on it.
3. You have to collect maximum coins by bursting all the balloons.
4. If you burst a balloon with index i, you will get (arr[i-1] * arr[i] * arr[i+1]) number of coins.
5. If arr[i-1] and arr[i+1] don't exist, then you may assume their value as 1.
Input Format
A number N
a1
a2.. N integers
Output Format
Check the sample output and question video.
Constraints
1 <= N <= 1000
1 <= arr[i] <= 100
Sample Input
3
1
2
3
Sample Output
12*/


import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] arr, int si, int ei, int[][] dp) {
        //write your code here
        int lval = si - 1 >= 0 ? arr[si - 1] : 1;
        int rval = ei + 1 < arr.length ? arr[ei + 1] : 1;

        if (si == ei) {
            return dp[si][ei] = lval * rval * arr[si];
        }

        if (dp[si][ei] != 0) {
            return dp[si][ei];
        }


        int max = Integer.MIN_VALUE;
        for (int cp = si; cp <= ei; cp++) {
            int lcoins = cp - 1 >= si ? solution(arr, si, cp - 1, dp) : 0;
            int rcoins = cp + 1 <= ei ? solution(arr, cp + 1, ei, dp) : 0;
            int myCoins = lcoins + rcoins + (lval * arr[cp] * rval);
            max = Math.max(myCoins, max);
        }

        return dp[si][ei] = max;
    }
    
    // --- tabulation method----
    public static int solution_tab(int[] arr) {
        //write your code here
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int si = 0, ei = gap; ei < n; si++, ei++) {

                int lval = si - 1 >= 0 ? arr[si - 1] : 1;
                int rval = ei + 1 < arr.length ? arr[ei + 1] : 1;

                if (si == ei) {
                    dp[si][ei] = lval * rval * arr[si];
                    continue;
                }

                int max = Integer.MIN_VALUE;
                for (int cp = si; cp <= ei; cp++) {
                    int lcoins = cp - 1 >= si ? dp[si][cp-1] : 0;
                    int rcoins = cp + 1 <= ei ? dp[cp+1][ei] : 0;
                    int myCoins = lcoins + rcoins + (lval * arr[cp] * rval);
                    max = Math.max(myCoins, max);
                }
                dp[si][ei] = max;
            }
        }
        return dp[0][n-1];
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution_tab(arr));
    }

}