import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    // write your code here  
    int n,c=0;
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    while(n!=0){
        c = c+1;
        n=n/10;
    }
    System.out.println(c);
   }
  }