/*Given an integer array and an integer (diff), return the length of the longest subsequence in array which is an arithmetic sequence such that the common difference of   AP is equal to diff.
Input Format

A number n
.. n more elements
A number which denotes common difference of AP.
Constraints

0 <= n <= 20
0 <= n1, n2, .. <= 100
-100 <= diff <= 100
Output Format

An Integer
Sample Input 0

9
1
5
7
8
5
3
4
2
1
-2
Sample Output 0

4
Explanation 0

The longest arithmetic subsequence is [7,5,3,1].*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        int d = sc.nextInt();
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            int l=1;
            int num = arr[i];
            for(int j=i;j<n;j++){
                
                if(arr[j] == num+d){
                    l++;
                    num = arr[j];
                }
                
            }
            if(max<l){
                 max = l;
            }
        }
        System.out.println(max);
    }
}
