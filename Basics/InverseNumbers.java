import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here  
      Scanner sc = new Scanner(System.in);
      int num = sc.nextInt();
      int var=0,pos=1;
        while(num!=0){
            int digit = num%10;
            int pow = (int)Math.pow(10,digit-1);
            var+=(pos*pow);
            pos++;
            num = num/10;
        }
        System.out.println(var);
     }
    }