/*
Question
  1. You are given a base b.
  2. You are given two numbers n1 and n2 of base b.
  3. You are required to add the two numbes and print their value in base b.
   
                                 
                                
                               
Input Format
A base b
  A number n1
  A number n2
  
Output Format
A number of base b2 equal in value to n of base b1.
  
Constraints
2 <= b <= 10
  0 <= n1 <= 256
  0 <= n2 <= 256
  
Sample Input
8
  777
  1
  
Sample Output
1000
*/
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getSum(b, n1, n2);
        System.out.println(d);
    }

    public static int getSum(int b, int n1, int n2) {
int carry = 0;
int result =0;
int mul = 1;
while(n1 !=0 || n2 !=0 || carry !=0){
    int d1 = n1%10;
    int d2 = n2%10;
    int D = d1+d2+carry;
    // OPTIMIZED LINE : No need of if-else. 
    carry = D/b;
    D = D%b;
    
    
    result += (D*mul);
    n1 /=10;
    n2 /=10;
    mul *= 10;
    
}
return result;
}

}