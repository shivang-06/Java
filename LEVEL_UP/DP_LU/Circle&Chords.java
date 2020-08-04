/*Question
1. You are given a number N.
2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
3. You have to find the number of ways in which these chords can be drawn.
Input Format
A number N
Output Format
Check the sample output and question video.
Constraints
1 <= N <= 1000
1 <= arr[i] <= 100
Sample Input
3*/
import java.io.*;
import java.util.*;

public class Main {

    public static long NumberOfChords_rec(int si, int ei) {
        //write your code here
        if (si == ei - 1) {
            return 1;
        }
        if (si >= ei) {
            return 1;
        }

        long res = 0;
        for (int cp = si + 1; cp <= ei; cp += 2) {
            long left = NumberOfChords(si + 1, cp - 1);
            long right = NumberOfChords(cp + 1, ei);
            long myWay = left * right;
            res += myWay;
        }
        return res;
    }

    public static long chords_tab(int n) {
        long[] dp = new long[2 * n + 1];
        dp[0] = 1;
        dp[2] = 1;
        for (int idx = 4; idx < dp.length; idx += 2) {
            int i = 0, j = idx - 2;
            while (i <= idx - 2) {
                dp[idx] += dp[i] * dp[j];
                i += 2;
                j -= 2;
            }
        }
        return dp[2 * n];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // System.out.println(NumberOfChords_rec(0, 2*n - 1));
        System.out.println(chords_tab(n));
    }   
}