/*Question
  1. You are given a number n.
  2. You are given a base b. n is a number on base b.
  3. You are required to convert the number n into its corresponding value in decimal number system.
  
                                
                               
Input Format
A number n
  A base b
  
Output Format
A decimal number representing corresponding value of n in base b.
  
Constraints
0 <= d <= 1000000000
  2 <= b <= 10
  
Sample Input
111001
  2
*/
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
    }

    public static int getValueIndecimal(int n, int b) {
        // write your code here
        int result = 0;
        int pow = 1;
        while (n != 0) {
            int dig = n % 10;
            result += dig * pow;
            pow *= b;
            n /= 10;
        }
        return result;
    }
}