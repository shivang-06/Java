/*
Question
  1. You are given a base b.
  2. You are given two numbers n1 and n2 of base b.
  3. You are required to subtract n1 from n2 and print the value.
  
                                
                               
Input Format
A base b
  A number n1
  A number n2
  
Output Format
A number of base b equal in value to n2 - n1.
  
Constraints
2 <= b <= 10
  0 <= n1 <= 256
  n1 <= n2 <= 256
  
Sample Input
8
  1
  100
  
Sample Output
77*/
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getDifference(b, n1, n2);
        System.out.println(d);
    }

    public static int getDifference(int b, int n1, int n2) {
        // write your code here
        int result = 0;
        int borrow = 0; 
        int pow = 1;
        // n2 is always greater than n1
        while (n2 != 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            int D = d2 - d1 - borrow;
            if((d2 - d1)<0){
                borrow = 1;
                D +=b;
            }else{
                borrow = 0;
            }
            result +=(D*pow);
            
            n2 /= 10;
            n1 /=10;
            pow *=10;
        }
        return result;
    }

}