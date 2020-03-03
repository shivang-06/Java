import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }

    public static int getValueInBase(int n, int b) {
        int rem=0;
        int pow=0;
        while (n != 0) {
            rem += (n % b)* (int)Math.pow(10,pow);
            n = n / b;
            pow++;
        }
        return rem;


    }
}