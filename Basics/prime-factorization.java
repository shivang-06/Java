/*
Question
  1. You are required to display the prime factorization of a number.
    2. Take as input a number n.
    3. Print all its prime factors from smallest to largest.
                               
                               
Input Format
n, an integer
Output Format
p1  p2  p3  p4.. all prime factors of n
Constraints
2 <= n < 10 ^ 9
Sample Input
1440
Sample Output
2  2  2  2  2  3  3  5
*/
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here  
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        for (int i = 2; i * i <= n; i++) {
            while (temp % i == 0) {
                System.out.print(i + " ");
                temp /= i;
            }
        }
        if (temp != 1) {
            System.out.print(temp);
        }
    }
}