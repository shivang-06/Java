/*
Question
 1. You are required to print the Greatest Common Divisor (GCD) of two numbers.
    2. You are also required to print the Lowest Common Multiple (LCM) of the same numbers.
    3. Take input "num1" and "num2" as the two numbers.
    4. Print their GCD and LCM.
                               
Input Format
num1
    num2
    .. the numbers whose GCD and LCM we have to find.
Output Format
a
    b
    .. where 'a' and 'b' are the GCD and LCM respectively.
Constraints
2 <= n <= 10^9
Sample Input
36
    24
Sample Output
12
    72
*/
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // write your code here
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = 1, lcm = 1;
        int temp = a;
        int temp2 = b;
        // int fact = 1;
        if (a > b) {

            for (int i = a; i < a * b;i+=a) {
                if ( i % b == 0) {
                    lcm =  i;
                    break;
                    // System.out.println(lcm);
                } 
            }
        } else {
            for (int i = b; i < a * b; i+=b) {
                if ( i%a == 0) {
                    lcm = i;
                    break;
                    // System.out.println(lcm);
                } 
            }

        }
        gcd = (a * b) / lcm;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}