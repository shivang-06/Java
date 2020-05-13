/*Given a cost matrix cost[][] and a position (m, n) in cost[][],
write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
Each cell of the matrix represents a cost to traverse through that cell. Total
cost of a path to reach (m, n) is sum of all the costs on that path
(including both source and destination). You can only traverse down, right and
diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells
(i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all
costs are positive integers.


Example

Input:
3 3
1 2 3
4 8 2
1 5 3

Output:
8
Input Format

First Line Of input is no. of rows and columns.
which is followed by its input in Positive integer.
Constraints

0< row,col <1000
0< a[i] < 1000
Output Format

Print output(min cost).
Sample Input 0

3 3
1 2 3
4 8 2
1 5 3
Sample Output 0

8*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0; j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
     printSum(arr,0,0,n-1,m-1,arr[0][0]);
        
        System.out.println(finalMin);
    }
    
    static int finalMin=Integer.MAX_VALUE;
    
    public static void printSum(int[][] arr, int sr, int sc, int dr, int dc, int cost) {
        
        if(sr==dr && sc==dc){
            if(finalMin>cost){
                System.out.println("cost before"+ finalMin);
                finalMin = cost;
                System.out.println("cost after" + finalMin);
         } 
            return;
         }
        //right move
        if(sc<dc){
            printSum(arr,sr,sc+1,dr,dc,cost+arr[sr][sc+1]); 
        }
        //down move
        if(sr<dr){
            printSum(arr,sr+1,sc,dr,dc,cost+arr[sr+1][sc]);
        }
        //diagonal move
        if(sr<dr && sc<dc){
             printSum(arr,sr+1,sc+1,dr,dc,cost+arr[sr+1][sc+1]);
        }
          
         }

}