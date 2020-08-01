/*Question
1. You are given two arrays - 
   The first array(keys), which is sorted and has distinct integers, represents search keys.
   Second one(freq) represents frequency counts, where freq[i] is the number of searches to keys[i].
2. A binary search tree is constructed containing all keys and the total cost of searches is minimum. 
3. The cost of a BST node is the level of that node multiplied by its frequency.
4. You have to find the minimum cost of all searches.
Input Format
A number N
a1
a2.. N integers
b1
b2.. N numbers
Output Format
Check the sample output and question video.
Constraints
1 <= N <= 1000
1 <= keys[i],freq[i] <= 1000
Sample Input
9
1
3
4
5
6
7
8
9
11
3
6
4
8
7
3
7
4
7
Sample Output
125*/

import java.io.*;
import java.util.*;

public class Main {

    public static int costofNodes(int[] freq, int si, int ei) {
        int sum = 0;
        for (int i = si; i <= ei; i++) {
            sum += freq[i];
        }
        return sum;
    }

    private static int optimalbst(int[] freq, int si, int ei,int[][] dp) {
        //write your code here
        if (si == ei) {
           return dp[si][ei] = freq[si];
           
        }
        if(dp[si][ei] != 0){
            return dp[si][ei];
        }
        int cost = costofNodes(freq,si,ei);

        int min = Integer.MAX_VALUE;
        for (int cp = si; cp <= ei; cp++) {
            int leftCost = cp - 1 >= si ? optimalbst(freq, si, cp - 1,dp) : 0;
            int rightCost = cp + 1 <= ei ? optimalbst(freq, cp + 1, ei,dp) : 0;
            int myCost = leftCost + rightCost + cost;
            min = Math.min(myCost, min);
        }

        return dp[si][ei] = min;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            frequency[i] = scn.nextInt();
        }
        System.out.println(optimalbst(frequency, 0, n - 1,new int[n][n]));
    }

}


// ------------------ 2nd Approach of cost of all nodes --------------------------
import java.io.*;
import java.util.*;

public class Main {
    private static int optimalbst(int[] freq, int si, int ei, int[][] dp) {
        //write your code here
        if (si == ei) {
            return dp[si][ei] = freq[si];

        }
        if (dp[si][ei] != 0) {
            return dp[si][ei];
        }
        int cost = 0; //cost of all nodes
        int min = Integer.MAX_VALUE;
        for (int cp = si; cp <= ei; cp++) {
            cost += freq[cp]; // at each point cut is made so no need to take loop to calculate cost of all nodes
            int leftCost = cp - 1 >= si ? optimalbst(freq, si, cp - 1, dp) : 0;
            int rightCost = cp + 1 <= ei ? optimalbst(freq, cp + 1, ei, dp) : 0;
            int myCost = leftCost + rightCost;
            min = Math.min(myCost, min);
        }
        min += cost; // added cost of all nodes
        return dp[si][ei] = min;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            frequency[i] = scn.nextInt();
        }
        System.out.println(optimalbst(frequency, 0, n - 1, new int[n][n]));
        // System.out.println(obst(frequency));
    }
}

// -------------- Tabulation Method -------------------
import java.io.*;
import java.util.*;

public class Main {    
    
    private static int obst(int[] freq) {
        int n = freq.length;
        int[][] dp = new int[n][n];
        
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                int si = i, ei = j;

                if (si == ei) {
                    dp[si][ei] = freq[si];
                    continue;
                }

                int cost = 0;
                int min = Integer.MAX_VALUE;

                for (int cp = si; cp <= ei; cp++) {
                    cost += freq[cp];
                    int lcost = cp - 1 >= si ? dp[si][cp - 1] : 0;
                    int rcost = cp + 1 <= ei ? dp[cp + 1][ei] : 0;
                    int myCost = lcost + rcost;
                    min = Math.min(min,myCost);
                }
                
                min += cost;
                dp[si][ei] = min;
            }
        }
        
        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            frequency[i] = scn.nextInt();
        }
        // System.out.println(optimalbst(frequency, 0, n - 1, new int[n][n]));
        System.out.println(obst(frequency));
    }

}