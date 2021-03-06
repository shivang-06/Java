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
	if (a < b) {
            for (int i = 2; i <= a / 2; i++) {
                if (temp % i == 0 && temp2 % i == 0) {
                    gcd = i;
                }

            }

        } else {
            for (int i = 2; i <= b / 2; i++) {
                if (temp % i == 0 && temp2 % i == 0) {
                    gcd = i;
                }

            }
        }
        lcm = (a * b) / gcd;
        System.out.println(gcd);
        System.out.println(lcm);

    }
}