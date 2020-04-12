/*Question
 1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to calculate the inverse of array a.

For definition and constraints check this link
https://www.pepcoding.com/resources/online-java-foundation/getting-started/inverse-of-a-number/ojquestion
The only difference is the range of values is from 0 to n - 1, instead
of 1 to n

                               
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
0 <= n < 10^7
For more constraints check this
https://www.pepcoding.com/resources/online-java-foundation/getting-started/inverse-of-a-number/ojquestion
The only difference is the range of values is from 0 to n - 1, instead
of 1 to n
Sample Input
5
4
0
2
3
1
Sample Output
1
4
2
3
0*/
import java.io.*;
import java.util.*;

public class Main{


  public static int[] inverse(int[] a){
    // write your code here
        int size = a.length;
    int[] temp = new int[size];
    for(int i = 0 ;i <a.length; i++){
        int tempVal = a[i];
        temp[tempVal] = i;
    }
    return temp;
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] inv = inverse(a);
    for(int i = 0; i< inv.length;i++){
        System.out.println(inv[i]);
    }
 }

}