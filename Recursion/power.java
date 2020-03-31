import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
       int pow = power(x,n);
       System.out.println(pow);
    }

    public static int power(int x, int n){
        int pow =1;
        if(n==0){
            return 1;
        }
        pow = x*power(x,n-1);
        return pow;
    }

}