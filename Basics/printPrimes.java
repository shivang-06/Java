/**
 Question
    1. You've to print all prime numbers between a range. 
 2. Take as input "low", the lower limit of range
 3. Take as input "high", the higher limit of range
 4. For the range print all the primes numbers between low and high (both included)
                               
                               
                               
                               
Input Format
low 
high
Output Format
n1
n2
.. all primes between low and high (both included)
Constraints
2 <= low < high < 10 ^ 6
Sample Input
6 
24
Sample Output
7
   11
   13
   17
   19
   23
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int low = scn.nextInt();

        int high = scn.nextInt();

        while (low <= high) {
            int n = low;
            int isprime = 1;
            for (int j = 2; j * j <= n; j++) {
                if (n % j == 0) {
                    isprime = 0;
                }

            }
            if (isprime == 1) {
                System.out.println(n);
            }
            low++;
        }
    }
}