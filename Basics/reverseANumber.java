import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     // write your code here 
           int n,digit;
    
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      while(n!=0){
        digit = n%10;
        System.out.println(digit);
        n=n/10;
      }
    }
   }