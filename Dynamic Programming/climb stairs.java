/*Question
    1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
3. You are required to print the number of different paths via which you can climb to the top.

                               
                               
                               
                               
Input Format
A number n
Output Format
A number representing the number of ways to climb the stairs from 0 to top.
Constraints
0 <= n <= 20
Sample Input
4
Sample Output
7*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] strg = new int[n+1];
        strg[0] = 1;
        for(int i=1 ; i<=n;i++){
            if(i-1>=0){
                strg[i] += strg[i-1];
            }
            if(i-2>=0){
                strg[i] += strg[i-2];
            }
            if(i-3>=0){
                strg[i] += strg[i-3];
            }
        }
        System.out.println(strg[n]);
    }

}