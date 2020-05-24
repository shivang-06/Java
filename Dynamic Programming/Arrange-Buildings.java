/*Question
    1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.

                               
                               
                               
                               
Input Format
A number n
Output Format
A number representing the number of ways in which the buildings can be built on both side of roads.
Constraints
0 < n <= 45
Sample Input
6
Sample Output
441*/
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();

      long zeroes = 1;
      long ones = 1;
      for (int i = 2; i <= n; i++) {
         long nzeroes = ones;
         long nones = ones + zeroes;

         zeroes = nzeroes;
         ones = nones;
      }

      long oneside = zeroes + ones;
      System.out.println(oneside * oneside);
   }

}