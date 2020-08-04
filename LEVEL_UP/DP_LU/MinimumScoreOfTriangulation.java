/*Question
1. You are given an array of integers, which represents the vertices of an N-sided convex polygon in clockwise order.
2. You have to triangulate the given polygon into N-2 triangles.
3. The value of a triangle is the product of the labels of vertices of that triangle.
4. The total score of the triangulation is the sum of the value of all the triangles.
5. You have to find the minimum score of the triangulation of the given polygon.
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
6*/
import java.io.*;
import java.util.*;

public class Main {

    public static int minScoreTriangulation(int[] arr, int si, int ei, int[][] dp) {
        //write your code here
        if (si + 1 == ei) {
            return dp[si][ei] = 0;
        }
        if (dp[si][ei] != 0) {
            return dp[si][ei];
        }
        int min = Integer.MAX_VALUE;
        for (int cp = si + 1; cp <= ei - 1; cp++) {
            int leftCost = minScoreTriangulation(arr, si, cp, dp);
            int rightCost = minScoreTriangulation(arr, cp, ei, dp);
            int mycost = (arr[si] * arr[cp] * arr[ei]) + leftCost + rightCost;
            if (min > mycost) {
                min = mycost;
            }
        }
        return dp[si][ei] = min;
    }
    public static int triangulation_tab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int gap = 2; gap < n; gap++) {
            for (int si = 0, ei = gap; ei < n; ei++, si++) {
                if (gap == 2) {
                    //BASE CASE
                    dp[si][ei] = arr[si] * arr[si + 1] * arr[si + 2];
                } else {
                    int res = Integer.MAX_VALUE;
                    for (int cp = si + 1; cp <= ei - 1; cp++) {
                        int left = dp[si][cp];
                        int right = dp[cp][ei];
                        int myScore = left + (arr[si] * arr[cp] * arr[ei]) + right;
                        res = Math.min(res, myScore);
                    }
                    dp[si][ei] = res;
                }
            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        // System.out.println(minScoreTriangulation(arr, 0, n - 1, new int[n][n]));
        System.out.println(triangulation_tab(arr));
    }
}