/*
Question
 1. You are given two numbers n and k. You are required to rotate n, k times to the right. If k is positive, rotate to the right i.e. remove rightmost
   digit and make it leftmost. Do the reverse for negative value of k. Also k can have an absolute value larger than number of digits in n.
   2. Take as input n and k.
   3. Print the rotated number.
   4. Note - Assume that the number of rotations will not cause leading 0's in the result. e.g. such an input will not be given
   n = 12340056
   k = 3
   r = 05612340
                               
Input Format
"n" where n is any integer.
   "K" where k is any integer.
Output Format
"r", the rotated number
Constraints
1 <= n < 10^9
   -10^9 < k < 10^9
Sample Input
562984
   2
Sample Output
845629
*/
import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     // write your code here 
    Scanner sc = new Scanner(System.in);
    int c=0;
    int temp;
    int n = sc.nextInt();
    temp = n;
    int k = sc.nextInt();
    // Count the digits
    while(temp!=0){
        c++;
        temp/=10;
    }
    //True rotation number find.
    int trn = k%c;
    // Negative case handle
    if(k<0){
        trn+= c;
    }
    // div,mul helpers
    int div = 1,mul = 1;
    for(int i=1;i<=c;i++){
        if(i<=trn){
            div*=10;
        }
        else{
            mul*=10;
        }
    }
    //Split the number
    int quo = n/div;
    int rem = n%div;
    
    //Merge
    int result = (rem*mul) + quo;
    // Result
    System.out.println(result);
    }
    }