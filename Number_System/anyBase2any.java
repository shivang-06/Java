/*
Question
   1. You are given a number n.
  2. You are given a base b1. n is a number on base b.
  3. You are given another base b2.
  4. You are required to convert the number n of base b1 to a number in base b2.
   
                                 
                                
                               
                               
Input Format
A number n
  A base b1
  A base b2
  
Output Format
A number of base b2 equal in value to n of base b1.
  
Constraints
0 <= n <= 512
  2 <= b1 <= 10
  2 <= b2 <= 10
  
Sample Input
111001
  2
  3
Sample Output
2010
*/
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();

        int d = getValue(n, b1, b2);
        System.out.println(d);
    }

    public static int getValue(int n, int b1, int b2) {
        int dec = 0;  // For storing converted anybase to decimal number.
        int result = 0; //For storing final converted value.
        int pow = 1;  
        int temp =n;
        
        
        // Any to decimal
        
        while (temp != 0) {
            int dig = temp % 10;
            dec += dig * pow;
            pow *= b1;
            temp /= 10;
        }
        
        
        //Decimal to any

        pow = 0;
        while (dec != 0) {
            result += (dec % b2) * (int) Math.pow(10, pow);
            dec = dec / b2;
            pow++;
        }
        return result; // final answer

    }


}