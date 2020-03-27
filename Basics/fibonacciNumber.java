import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      int a=0,b=1,n,i=2;
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      if(n==0){
          System.out.println(a);
      }
      System.out.println(a);
      System.out.println(b);
    while(i<n){
        int temp = a+b;
        System.out.println(temp);
        a=b;
        b=temp;
        i++;
    }
  }
  }