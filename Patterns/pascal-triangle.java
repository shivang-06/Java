                    // 1	
                    // 1	1	
                    // 1	2	1	
                    // 1	3	3	1	
                    // 1	4	6	4	1	
                    // 1	5	10	10	5	1	
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        // int val = 1;
        for (int i = 0; i < n; i++) {
            int val = 1;
            for (int j = 0; j <= i; j++) {
                    System.out.print(val+"	");
                    val = ((i-j)*val)/(j+1);  // nCr+1 = (n-r)/r+1 * nCr
            }
                System.out.println();

        }
    }
}