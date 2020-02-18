/**
 * isPrime
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