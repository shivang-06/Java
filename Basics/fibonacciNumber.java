/*
Question
 1. You've to print first n fibonacci numbers.
  2. Take as input "n", the count of fibonacci numbers to print.
  3. Print first n fibonacci numbers.
                               
Input Format
n
Output Format
0
  1
  1
  2
  3
  5
  8
  .. first n fibonaccis
Constraints
1 <= n < 40
Sample Input
10
Sample Output
0
  1
  1
  2
  3
  5
  8
  13
  31
  34
*/
import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      int a=0,b=1,n,i=2;
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      if(n==0){
          System.out.println(a);
      }
      System.out.println(a);
      System.out.println(b);
    while(i<n){
        int temp = a+b;
        System.out.println(temp);
        a=b;
        b=temp;
        i++;
    }
  }
  }