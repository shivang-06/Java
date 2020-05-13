/*
Mr. Pepper is facing a problem in understanding some information.
He will be able to able to understand the information, if he is able
to find "point of parity".
Your task is to help him find such point. 
(if "point of parity" exists print such point, otherwise print "-1")

"point of parity" is defined as a place (index),which acts as a neutral-point.

Example : 
arr[] = {-10,-5,20,3,10,-5}
point of parity = 3
as ,arr[0] + arr[1] + arr[2] = arr[4] + arr[5].
Input Format

1. N (a number, representing size of input)
2. ele1 , ele2 , ele3 , ...... elen ( N more inputs,elements)
Constraints

0 <= N <= 100,000
Output Format

if "point of parity" exists print such point, otherwise print "-1"
Sample Input 0

5
1 3 5 2 2
Sample Output 0

2
Explanation 0

position 2 as elements below it (1+3) = elements after it (2+2).

Sample Input 1

6
-10 -5 20 3 10 -5
Sample Output 1

3
*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        
        for(int i=0;i<n;i++){
            int fin=0;
        int sum=0;
            for(int j=0;j<i;j++){
                fin+=a[j];
            }
            for(int k=n-1;k>i;k--){
                sum+=a[k];
            }
            if(fin==sum)
            {System.out.println(i);
            return;} 
        }
        System.out.println("-1");
        
    }
}
