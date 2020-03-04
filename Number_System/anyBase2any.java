import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();

        int d = getValue(n, b1, b2);
        System.out.println(d);
    }

    public static int getValue(int n, int b1, int b2) {
        int dec = 0;  // For storing converted anybase to decimal number.
        int result = 0; //For storing final converted value.
        int pow = 1;  
        int temp =n;
        
        
        // Any to decimal
        
        while (temp != 0) {
            int dig = temp % 10;
            dec += dig * pow;
            pow *= b1;
            temp /= 10;
        }
        
        
        //Decimal to any

        pow = 0;
        while (dec != 0) {
            result += (dec % b2) * (int) Math.pow(10, pow);
            dec = dec / b2;
            pow++;
        }
        return result; // final answer

    }


}