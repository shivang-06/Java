package Number_System;

import java.util.*;

public class decimal2anyBase_approach2 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }       
    public static int getValueInBase(int n, int b) { 
    // APPROACH   2 __________________________    
        int result = 0;
        int pow = 1;
        while (n != 0) {
            int rem = n % b;
            result =result + (rem * pow);
            pow = pow * 10;
            n = n / b;
        }
        return result;
    }
}
