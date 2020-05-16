/*Question
   1. You are given a number n.
2. You are required to print the nth element of fibonnaci sequence.
Note -> Notice precisely how we have defined the fibonnaci sequence
0th element -> 0
1st element -> 1
2nd element -> 1
3rd element -> 2
4th element -> 3
5th element -> 5
6th element -> 8
..

                               
                               
                               
Input Format
A number n
Output Format
A number representing the nth element of fibonnaci sequence
Constraints
0 <= n <= 45
Sample Input
10
Sample Output
55*/
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();    
    
    System.out.println(fibT(n));
    
 }
 //Tabulation method
 public static int fibT(int n){
     int[] strg = new int[n+1];
     strg[0] = 0;
     strg[1] = 1;
     for(int i=2;i<strg.length;i++){
        strg[i] = strg[i-1] + strg[i-   2];
    }
    
    return strg[n];
 }
}