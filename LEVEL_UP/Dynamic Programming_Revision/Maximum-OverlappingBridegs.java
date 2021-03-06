/*Question
1. You are given a number n, representing the number of bridges on a river.
2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
3. You are required to print the count of maximum number of non-overlapping bridges.
                               
Input Format
A number n
.. n pair of number each on a separate line (and pair separated by space)
Output Format
A number representing the count of maximum number of non-overlapping bridges.
Constraints
0 <= n <= 20
0 <= n1n, n1s, n2n, n2s, .. <= 100
Sample Input
4
43 26
82 53
94 23
58 32


Sample Output
3*/
import java.io.*;
import java.util.*;

public class Main {
    //Comparable interface is used to sort user defined datatype with help of compareTo class.
    static class pair implements Comparable < pair > {
        int nb;
        int sb;

        public int compareTo(pair other) {
            if(this.nb!=other.nb){
                return this.nb - other.nb;
            }else{
                return this.sb-other.sb;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pair bridges[] = new pair[n];
        for (int i = 0; i < n; i++) {
            pair bridge = new pair();
            bridge.nb = sc.nextInt();
            bridge.sb = sc.nextInt();
            
            bridges[i] = bridge;
        }
        Arrays.sort(bridges);

        int[] dp = new int[n];

        // applying longest increasing subsequnce on the basis of south banks of bridges
        for (int i = 0; i < n; i++) {
            int max = 0;
            
            for (int j = 0; j < i; j++) {
                if ((bridges[j].sb < bridges[i].sb) && (max < dp[j])) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            
        }

        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        System.out.println(ans);
    }

}