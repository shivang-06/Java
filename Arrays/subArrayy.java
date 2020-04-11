/*Question
 1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to print all subarrays of arr. Each subarray should be
on separate line. For more clasrity check out sample input and output

                               
Input Format
A number n
n1
n2
.. n number of elements
Output Format
[Tab separated elements of subarray]
..
All subarrays
Constraints
1 <= n <= 10
0 <= n1, n2, .. n elements <= 10 ^9
Sample Input
3
10
20
30
Sample Output
10
10  20
10  20  30
20
20  30
30*/
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i=0;i<a.length;i++){
        a[i] = sc.nextInt();
    }
    
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                for(int k=i; k<=j;k++){
                    System.out.print(a[k]+"	");
                }
            System.out.println();
            }
        }
}
 

}