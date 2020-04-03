/*
Question
  1. You are given a decimal number n.
  2. You are given a base b.
  3. You are required to convert the number n into its corresponding value in base b.
  
                                
                               
Input Format
A number n
  A base b
  
Output Format
A number representing corresponding value of n in number system of base b
  
Constraints
0 <= d <= 512
  2 <= b <= 10
  
Sample Input
57
  2*/

import java.util.*;

public class decimal2anyBase_approach2 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }       
    public static int getValueInBase(int n, int b) { 
    // APPROACH   2 __________________________    
        int result = 0;
        int pow = 1;
        while (n != 0) {
            int rem = n % b;
            result =result + (rem * pow);
            pow = pow * 10;
            n = n / b;
        }
        return result;
    }
}
