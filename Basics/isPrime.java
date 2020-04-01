/**
 
Question
 1. You've to check whether a given number is prime or not.
  2. Take a number "t" as input representing count of input numbers to be tested.
  2. Take a number "n" as input "t" number of times.
  3. For each input value of n, print "prime" if the number is prime and "not prime" otherwise.
                               
Input Format
A number t
  A number n
  A number n
  .. t number of times
Output Format
prime
  not prime
  not prime
  .. t number of times
Constraints
1 <= t <= 10000
  2 <= n < 10^9
Sample Input
5
  19
  21
  33
  37
  121
Sample Output
prime
  not prime
  not prime
  prime
  not prime
 */
import java.util.*;
public class isPrime {

    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
        
            int t,n,j=0;
            t=scn.nextInt();
            for(int i=0;i<t;i++){
                n= scn.nextInt();
                for( j=2;j*j<n;j++){
                    if(n%j==0){
                        System.out.println("not prime");
                        break;
                    }
            }
                if(j*j>=n)
                        System.out.println("prime");
                }
        
    }
}