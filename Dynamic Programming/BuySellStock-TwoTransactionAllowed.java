/*Question
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)

                               
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
Sample Input
2
0
7

Sample Output
7*/
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
        int min = price[0];
        int[] left = new int[n];

        for (int i = 1; i < n; i++) {
            if (min > price[i]) {
                min = price[i];
            }
            left[i] = Math.max(left[i - 1], price[i] - min);
        }

        int max = price[n - 1];
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (max < price[i]) {
                max = price[i];
            }
            right[i] = Math.max(right[i + 1], max - price[i]);
        }

        int maxProfit = left[0] + right[0];
        for (int i = 1; i < n; i++) {
            if (maxProfit < left[i] + right[i]) {
                maxProfit = left[i] + right[i];
            }
        }
        System.out.println(maxProfit);
    }

}   