import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int pow = power(x, n);
        System.out.println(pow);
    }

    public static int power(int x, int n) {
        int powb2 = 1;
        if (n == 0) {
            return 1;
        }
        if(n==1){
            return x;
        }
        
        powb2 = power(x, n/2);

        if(n%2 == 0){
            return powb2*powb2;
        }else{
            return powb2*powb2*x;
        }
        
    }

}