/*Question
 1. You are given a string str.
2. You are required to print the count of palindromic subsequences in string str.
                               
Input Format
A string str
Output Format
A number representing the count of palindromic subsequences in string str.
Constraints
0 <= str.length <= 10
Sample Input
ccbbgd
Sample Output
8*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int[][] dp = new int[str.length()][str.length()];

        for (int dia = 0; dia < str.length(); dia++) {
            for (int i = 0, j = dia; j < str.length(); i++, j++) {
                if (dia == 0) {
                    dp[i][j] = 1;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    }
                }
            }
        }
        System.out.println(dp[0][str.length() - 1]);


    }

}