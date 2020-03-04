import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
    }

    public static int getValueIndecimal(int n, int b) {
        // write your code here
        int result = 0;
        int pow = 1;
        while (n != 0) {
            int dig = n % 10;
            result += dig * pow;
            pow *= b;
            n /= 10;
        }
        return result;
    }
}