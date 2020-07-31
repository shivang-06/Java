/*Question
1. You are given a string.
2. You have to find the minimum number of cuts required to convert the given string into palindromic partitions.
3. Partitioning of the string is a palindromic partitioning if every substring of the partition is a palindrome.
Input Format
A string
Output Format
Check the sample output and question video.
Constraints
1 <= length of string <= 10^4
Sample Input
abccbc
Sample Output
2*/
import java.io.*;
import java.util.*;

public class Main {

    public static int minPalindromicCut_tab(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int gap = 1; gap < n; gap++) {
            for (int si = 0, ei = gap; ei < n; si++, ei++) {
                if (gap == 1) {
                    //2-length string
                    if (str.charAt(si) != str.charAt(ei)) {
                        dp[si][ei] = 1;
                    }
                } else {

                    if (str.charAt(si) == str.charAt(ei) && dp[si + 1][ei - 1] == 0) {
                        dp[si][ei] = 0;
                        continue;
                    }

                    int min = Integer.MAX_VALUE;
                    for (int cp = si + 1; cp <= ei; cp++) {
                        int left = dp[si][cp - 1];
                        int right = dp[cp][ei];
                        int tCut = left + right + 1; //total cuts
                        min = tCut < min ? tCut : min;
                    }
                    dp[si][ei] = min;
                }
            }
        }
        return dp[0][n - 1];
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(minPalindromicCut_tab(str));
    }
}