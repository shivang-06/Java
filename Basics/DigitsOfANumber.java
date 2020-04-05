/*Question
  1. You've to display the digits of a number.
    2. Take as input "n", the number for which digits have to be displayed.
    3. Print the digits of the number line-wise
                               
                               
Input Format
"n" where n is any integer.
Output Format
d1
    d2
    d3
    ... digits of the number
Constraints
1 <= n < 10^9
Sample Input
65784383
Sample Output
6
5
7
8
4
3
8
3*/
import java.util.*;
import java.lang.*;
public class Main {

    public static void main(String[] args) {
        // write your code here  
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long count = 0;
        long temp = n;
        long mul = 1;
        while (n >= 10) {
            mul = mul * 10;
            n = n / 10;

        }


        while (mul != 0) {

            long digit = temp / mul;
            System.out.println(digit);
            temp = temp % mul;

            mul = mul / 10;



        }
    }
}