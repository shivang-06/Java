/*Mr. pepper wants to help a farmer by letting him know how much he can 
collect water rain-water, so that farmer can use this information, 
correctly & efficiently.

caculate Maximum rainwater , you can collect.
(see the image below to understand the question)

Example : 
Input: arr[]   = {3, 0, 2, 0, 4}
Output: 7
![image](https://s3.amazonaws.com/hr-assets/0/1589030464-0e507386bc-Capture.PNG)
Input Format

1. N (a number, representing size of input, structure size)
2. ele1 , ele2 , ele3 , ...... elen ( N more inputs,elements)
Constraints

0 <= N <= 100,000
Output Format

print a number that can represents, amount(int units) of rain-water collected.
Sample Input 0

5
4 0 3 0 4
Sample Output 0

9*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        
        int answer=0;
        int max = 0;
        int secMax=0;
        int i=0;
        int j=arr.length-1;
        
        while(i<=j){
            if(arr[i]<arr[j]){
                if(arr[i]>max){
                    max = arr[i];
                }
                else{
                    answer += max - arr[i];
                    i++;
                }
            }
            else{
                if(arr[j]>secMax){
                    secMax = arr[j];
                }
                else{
                    answer += secMax - arr[j];
                    j--;
                }
            }
        }
        System.out.println(answer);
       
    }
}