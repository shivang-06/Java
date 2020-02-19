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