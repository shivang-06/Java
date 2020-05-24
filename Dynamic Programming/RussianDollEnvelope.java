/*Question
1. You are given a number n, representing the number of envelopes.
2. You are given n pair of numbers, representing the width and height of each envelope.
3. You are required to print the count of maximum number of envelopes that can be nested inside each other.
Note -> Rotation is not allowed
Input Format
A number n
.. n pair of number each on a separate line (and pair separated by space)
Output Format
A number representing the count of maximum number of envelopes that can be nested inside each other.
Constraints
0 <= n <= 20
0 <= n1w, n1h, n2w, n2h, .. <= 100
Sample Input
11
17 5
26 18
25 34
48 84
63 72
42 86
9 55
4 70
21 45
68 76
58 51
Sample Output
5*/
import java.io.*;
import java.util.*;

public class Main {

    static class pair implements Comparable < pair > {
        int width; //north bank
        int height; //south bank
        public int compareTo(pair other) {
            if (this.width != other.width) {
                return this.width - other.width;
            } else {
                return this.height - other.height;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pair[] envelopes = new pair[n];
        for (int i = 0; i < n; i++) {
            pair envelope = new pair();
            envelope.width = sc.nextInt();
            envelope.height = sc.nextInt();

            envelopes[i] = envelope;
        }
        Arrays.sort(envelopes);
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            
            for (int j = 0; j < i; j++) {
                if (envelopes[i].height > envelopes[j].height && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }

        int lis = dp[0];
        for (int i = 1; i < n; i++) {
            if (lis < dp[i]) {
                lis = dp[i];
            }
        }
        System.out.println(lis);
    }

}