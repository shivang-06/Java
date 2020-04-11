/*Question
 1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to print all subsets of arr. Each subset should be
on separate line. For more clarity check out sample input and output
 
                               
                               
Input Format
A number n
n1
n2
.. n number of elements
Output Format
[Tab separated elements of subset]
..
All subsets
Constraints
1 <= n <= 10
0 <= n1, n2, .. n elements <= 10^3
Sample Input
3
10
20
30
Sample Output
-   -   -
-   -   30
-   20  -
-   20  30
10  -   -
10  -   30
10  20  -
10  20  30*/
import java.io.*;
import java.util.*;

public class Main {

    public static int[] binary(int a, int n) {
        int[] binaryArr = new int[n];
        int pos = n - 1;
        while (a != 0) {
            binaryArr[pos] = a % 2;
            pos--;
            a /= 2;
        }
        return binaryArr;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int N = (int) Math.pow(2, n);
        for (int i = 0; i < N; i++) {
            int[] temp = binary(i, n);
            for (int j = 0; j < temp.length; j++) {
                    if(temp[j] == 1){
                        System.out.print(arr[j]+"	");
                    }else{
                        System.out.print("-	");
                    }
            }
            System.out.println();
        }




    }

}