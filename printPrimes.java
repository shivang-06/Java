import java.util.*;
   
   public class Main{
       public static void main(String[] args) {
           // write your code here
           Scanner sc = new Scanner(System.in);
           int low,high,j;
           low = sc.nextInt();
           high = sc.nextInt();
           for(int i=low;i<=high;i++){
               for( j=2;j*j<=high;j++){
                   if(i%j==0){
                      System.out.println(i); 
                       break;
                   }
               }
               if(j*j>=high)
               System.out.println(i);
           }
       }
   }