/*Question
  1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print a bar chart representing value of arr a.

                               
                               
Input Format
A number n
n1
n2
.. n number of elements
Output Format
A bar chart of asteriks representing value of array a
Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 10
Sample Input
5
3
1
0
7
5
Sample Output
            *   
            *   
            *   *
            *   *
*           *   *
*           *   *
*   *       *   *

*/
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    int maxId = 0;
    int max = Integer.MIN_VALUE;
    for(int i = 0 ; i<arr.length ; i++){
        arr[i] = sc.nextInt();
        if(max<arr[i]){
            max = arr[i];
        }
    }
    // int curr =max;
    for(int i=0;i<max;i++){
        for(int j =0;j<arr.length;j++){
            if(arr[j] >= max){
                System.out.print("*\t");
            }else{
                System.out.print("\t");
            }
            arr[j]++;
        }
        System.out.println();
        // curr--;
    }
}

}