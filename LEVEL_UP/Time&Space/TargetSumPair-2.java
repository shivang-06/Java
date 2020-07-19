/*Question
1. You are given an array(arr) of distinct integers, which is sorted and rotated around an unknown point.
2. You are also given a target.
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
-10^9 <= arr[i] <= 10^9
Sample Input
9
15
16
19
21
23
24
1
2
12
25
Sample Output
1, 24
2, 23*/
import java.io.*;
import java.util.*;

public class Main {

    public static int findPivot(int arr[]) {
        for(int i = 1;i<arr.length;i++){
            if(!(arr[i] > arr[i-1])){
                return i; //pivot index
            }
        }
        return 0;
    }

    public static void targetSumPair(int[] arr, int target) {
        //write your code here
        int pIdx = findPivot(arr);
        int i = pIdx;
        int j = pIdx - 1;
        int count = 0;
        while (arr.length - count > 1) { // 1 because pairs can only exist in minimum 2 elements. can also be written as count<arr.length-1.
            if (arr[i] + arr[j] > target) {
                //j-- =>
                j = (j - 1 + arr.length) % arr.length; // to provide circular behaviour.
                count++;
            } else if (arr[i] + arr[j] < target) {
                //i++ =>
                i = (i + 1) % arr.length; // to provide circular behaviour.
                count++;
            } else if (arr[i] + arr[j] == target) {
                System.out.println(arr[i] + ", " + arr[j]);
                i = (i + 1) % arr.length;
                j = (j - 1 + arr.length) % arr.length;
                count += 2;
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