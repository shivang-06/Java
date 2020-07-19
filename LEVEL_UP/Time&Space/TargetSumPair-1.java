/*Question
1. You are given an array(arr) of distinct integers and a target.
2. You have to print all the pairs having their sum equal to the target.
Input Format
An Integer N 
arr1
arr2..
n integers
An integer target
Output Format
Check the sample output and question video.
Constraints
1 <= N <= 10000
-10^9<= arr[i] <= 10^9
Sample Input
12
9 
-48 
100 
43 
84 
74 
86 
34 
-37 
60 
-29 
44
160
Sample Output
60, 100
74, 86*/
import java.io.*;
import java.util.*;

public class Main {

    public static void targetSumPair(int[] arr, int target) {
        //write your code here
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] > target) {
                j--;
            } else if (arr[i] + arr[j] < target) {
                i++;
            } else if (arr[i] + arr[j] == target) {
                System.out.println(arr[i] + ", " + arr[j]);
                i++;
                j--;
            }
        }

    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr, target);
    }

}