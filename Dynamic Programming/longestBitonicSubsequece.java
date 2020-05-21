/*Question
 1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest bitonic subsequence of array.
Note -> bitonic subsequence begins with elements in increasing order, followed by elements in decreasing order.
                               
Input Format
A number n
.. n more elements
Output Format
A number representing the length of longest increasing subsequence of array.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 100
Sample Input
10
10
22
9
33
21
50
41
60
80
1
Sample Output
7*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] incDP = new int[n];
        int[] decDP = new int[n];

        //longest increasing subsequece
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && max < incDP[j]) {
                    max = incDP[j];
                }
            }
            incDP[i] = max + 1;
        }

        //longes decreasing subsequece
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j] && max < decDP[j]) {
                    max = decDP[j];
                }
            }
            decDP[i] = max + 1;

        }

        int ans = incDP[0] + decDP[0] - 1;
        for (int i = 1; i < n; i++) {
            if (ans < incDP[i] + decDP[i] - 1) {
                ans = incDP[i] + decDP[i] - 1;
            }
        }
        System.out.println(ans);

    }

}