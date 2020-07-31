/*Question
1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.
Input Format
A number N
arr1
arr2.. N integers
Output Format
Check the sample output and question video.
Constraints
2 <= N <= 1000
1 <= arr[i] <= 500
Sample Input
3
1
2
3
Sample Output
6*/
import java.io.*;
import java.util.*;

public class Main {

    public static int mcm(int[] arr, int si, int ei) {
        //write your code here
        if ((ei - si) == 1) {
            return 0;
        }
        if ((ei - si) == 2) {
            int mult = 1;
            for (int i = si; i <= ei; i++) {
                mult *= arr[i];
            }
            return mult;
        }

        int minVal = Integer.MAX_VALUE;
        for (int cp = si + 1; cp < ei; cp++) {
            //left
            int leftCost = mcm(arr, si, cp);
            //right
            int rightCost = mcm(arr, cp, ei);
            //Answer
            int ans = leftCost + rightCost + (arr[si] * arr[ei] * arr[cp]);

            minVal = Math.min(ans, minVal);

        }

        return minVal;
    }
    public static int mcm_mem(int[] arr, int si, int ei, int[][] dp) {
        if ((ei - si) == 1) {
            return 0;
        }
        if ((ei - si) == 2) {
            int mult = 1;
            for (int i = si; i <= ei; i++) {
                mult *= arr[i];
            }
            return mult;
        }
        if (dp[si][ei] != 0) {
            return dp[si][ei];
        }

        int minVal = Integer.MAX_VALUE;
        for (int cp = si + 1; cp < ei; cp++) {
            //left
            int leftCost = mcm_mem(arr, si, cp, dp);
            //right
            int rightCost = mcm_mem(arr, cp, ei, dp);
            //Answer
            int ans = leftCost + rightCost + (arr[si] * arr[ei] * arr[cp]);

            minVal = Math.min(ans, minVal);

        }
        dp[si][ei] = minVal;
        return minVal;
    }
    public static int mcm_tab(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int gap = 2; gap < arr.length; gap++) {
            for (int si = 0, ei = gap; ei < arr.length; si++, ei++) {
                //cut point code
                int min = Integer.MAX_VALUE;
                for(int cp =si+1;cp<ei;cp++){
                    int leftCost = dp[si][cp];
                    int rightCost = dp[cp][ei];
                    
                    int ans = leftCost + rightCost + (arr[si] * arr[ei] * arr[cp]);
                    min = Math.min(min,ans);
                }
                dp[si][ei] = min;
            }
        }
        return dp[0][arr.length-1];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(mcm_tab(arr));
    }


}