/*Question
1. You are given a string str.
2. You are required to print the length of longest of palindromic substrings in string str.
Input Format
A string str
Output Format
A number representing the length of longest of palindromic substrings in string str.
Constraints
0 <= str.length <= 10
Sample Input
abccbc
Sample Output
4*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean[][] dp = new boolean[str.length()][str.length()];
        int maxLen = 0;

        for (int dia = 0; dia < str.length(); dia++) {
            for (int i = 0, j = dia; j < str.length(); i++, j++) {
                if (dia == 0) {
                    dp[i][j] = true;
                } else if (dia == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j] == true) {
                    maxLen = dia + 1;
                }
            }
        }
        System.out.println(maxLen);

    }

}