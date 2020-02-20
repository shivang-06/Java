        // 				*	
        // 			*	*	
        // 		*	*	*	
        // 	*	*	*	*	
    // *	*	*	*	*	

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int nrow = n;
        int irow = 1;
        int nstar = 1;
        int nspace = n - 1;
        while (irow <= nrow) {
            int ispace = 1;
            while (ispace<=nspace) {
                System.out.print("\t");
                ispace++;
            }
            nspace--;
            int istar = 1;
            while (istar <= nstar) {
                System.out.print("*\t");
                istar++;
            }
            System.out.println();
            nstar++;
            irow++;
            //  nspace-=irow;
        }

    }
}