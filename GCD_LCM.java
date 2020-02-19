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
	if (a < b) {
            for (int i = 2; i <= a / 2; i++) {
                if (temp % i == 0 && temp2 % i == 0) {
                    gcd = i;
                }

            }

        } else {
            for (int i = 2; i <= b / 2; i++) {
                if (temp % i == 0 && temp2 % i == 0) {
                    gcd = i;
                }

            }
        }
        lcm = (a * b) / gcd;
        System.out.println(gcd);
        System.out.println(lcm);

    }
}