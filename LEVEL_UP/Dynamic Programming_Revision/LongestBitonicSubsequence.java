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
15
55
39
83
28
13
14
100
32
98
13
87
12
94
39
90

Sample Output
6*/
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
        //lis
        int[] dpLis = new int[n];
        dpLis[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && dpLis[j] > max) {
                    max = dpLis[j];
                }
            }
            dpLis[i] = max + 1;
        }

        //lis from len-1 (basically lds if start from 0 idx)
        int[] dpLds = new int[n];
        dpLds[n - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int min = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i] && min < dpLds[j]) {
                    min = dpLds[j];
                }
            }
            dpLds[i] = min + 1;
        }

        //bitonic length
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, (dpLis[i] + dpLds[i] - 1));
        }
        System.out.println(max);

    }

}