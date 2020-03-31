import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fact = 1;
        fact = factorial(n);
        System.out.println(fact);
    }

    public static int factorial(int n){
        int fact =1;
        if(n==0){
            return 1;
        }
        
        fact = n*factorial(n-1);
        return fact;
    }

}