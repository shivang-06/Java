/*1. you will be provided unique elements.
2. your task is to group same elements together in order of unique elements.
![image](https://s3.amazonaws.com/hr-assets/0/1591193484-c58fb5f956-Capture.PNG)
Input Format

n(representing number of uniqueu-elements)
uEle1 uEle2 uEle3 .... uElen(n more unique inputs)

t(representing number of t-unordered-elements)
ele1 ele2 ele3 .... elet(t more  inputs)
Constraints


Output Format

print correct order(t elements following particular order)
Sample Input 0

3
12 10 11 
8
11 12 12 11 12 10 12 12
Sample Output 0

12 12 12 12 12 10 11 11*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] a=new int[n1];
        for(int i=0; i<n1; i++)
        {
            a[i] = sc.nextInt();
        }
       
       int n2 = sc.nextInt();
       int[] b = new int[n2];
        for(int j=0; j<n2; j++)
        {
            b[j] = sc.nextInt();
        }
       
        int[] ans = new int[n2];
        int idx = 0;
        for(int k=0; k<n1; k++){
            for(int l=0; l<n2; l++){
                if(b[l] == a[k]){
                    ans[idx]=b[l];
                    System.out.print(ans[idx]+" ");
                    idx++;  
                }
            }
        }
    }
}  
