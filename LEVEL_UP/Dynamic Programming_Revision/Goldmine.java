/*Question
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).

goldmine

6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.

                               
                               
                               
                               
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
Maximum gold available.
Constraints
1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000
Sample Input
5
25
40 51 36 26 46 82 82 79 4 81 56 52 63 76 51 10 30 43 37 43 53 93 81 46 63 
62 49 59 75 5 36 73 94 70 25 1 57 14 20 58 38 31 58 75 22 87 4 20 23 33 
67 47 95 42 2 56 73 66 22 57 64 66 72 7 53 1 77 56 7 45 4 52 11 50 1 
91 42 1 90 7 44 97 19 63 73 45 0 61 31 27 49 50 95 55 83 60 51 74 87 32 
62 47 94 61 10 44 83 14 53 7 39 53 44 21 91 70 38 76 97 5 42 16 39 14 89 

Sample Output
1833*/

import java.io.*;
import java.util.*;

public class Main {
    public static int goldMine_rec(int[][] mine, int i, int j) {
        if (j == mine[0].length - 1) {
            return mine[i][j];
        }
        int g1 = (i - 1) >= 0 ? goldMine_rec(mine, i - 1, j + 1) : 0;
        int g2 = goldMine_rec(mine, i, j + 1);
        int g3 = (i + 1) <= mine.length ? goldMine_rec(mine, i + 1, j + 1) : 0;
        return Math.max(g1, Math.max(g2, g3)) + mine[i][j];
    }
    
    
    public static int goldMine_mem(int[][] mine, int i, int j, int[][] dp) {
        if (j == mine[0].length - 1) {
            return dp[i][j] = mine[i][j];
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int g1 = (i - 1) >= 0 ? goldMine_mem(mine, i - 1, j + 1, dp) : 0;
        int g2 = goldMine_mem(mine, i, j + 1, dp);
        int g3 = (i + 1) <= mine.length-1 ? goldMine_mem(mine, i + 1, j + 1, dp) : 0;
        return dp[i][j] = (Math.max(g1, Math.max(g2, g3)) + mine[i][j]);
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mine = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mine[i][j] = sc.nextInt();
            }
        }
        int maxGold = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {   
            int ans = goldMine_mem(mine, i, 0, dp);
            maxGold = Math.max(ans, maxGold);
        }
        System.out.println(maxGold);
    }

}