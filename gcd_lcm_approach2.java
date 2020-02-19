import java.util.*;

public class Main {

    public static void main(String[] args) {

        // write your code here
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = 1, lcm = 1;
        int temp = a;
        int temp2 = b;
        // int fact = 1;
        if (a > b) {

            for (int i = a; i < a * b;i+=a) {
                if ( i % b == 0) {
                    lcm =  i;
                    break;
                    // System.out.println(lcm);
                } 
            }
        } else {
            for (int i = b; i < a * b; i+=b) {
                if ( i%a == 0) {
                    lcm = i;
                    break;
                    // System.out.println(lcm);
                } 
            }

        }
        gcd = (a * b) / lcm;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}