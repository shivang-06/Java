/*Question
1. You are given a string str1.
2. You are given another string str2.
3. You are required to print the length of longest common subsequence of two strings.
Input Format
A string str1
A string str2
Output Format
A number representing the length of longest common subsequence of two strings.
Constraints
0 <= str1.length <= 10
0 <= str2.length <= 10
Sample Input
aadb
ccdb

Sample Output
2*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        
        for(int i = str1.length()-1;i>=0;i--){
            for(int j = str2.length()-1;j>=0;j--){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        System.out.println(dp[0][0]);

    }

}