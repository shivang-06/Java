/*Question
  Description
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.

                               
                               
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
Sample Input
9
11
6
7
19
4
1
6
18
4
Sample Output
17*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        int min = price[0]; //minimun price
        int maxProfit = 0; 
        for (int i = 0; i < n; i++) {
            if (price[i] < min) {
                min = price[i];
            }
            int profit = price[i] - min;//profit after selling a stock
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        System.out.println(maxProfit);
    }
}