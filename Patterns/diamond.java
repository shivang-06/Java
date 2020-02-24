                    // 		*	
                    // 	*	*	*	
                // *	*	*	*	*	
                    // 	*	*	*	
                    // 		*	


import java.util.*;

public class diamond {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int nrow = n;
        int irow = 1;
        int nstar = 1;
        int nspace = n/2;
        while (irow <= n) {
            int ispace = 1;
            while (ispace <= nspace) {
                System.out.print("\t");
                ispace++;
            }
            int istar = 1;
            while (istar <= nstar) {
                System.out.print("*\t");
                istar++;
            }
            
            System.out.println();
            if(irow<=(n/2)){
                nspace--;
                nstar+=2;
            }else{
                nspace++;
                nstar-=2;
            }
            irow++;
            

        }


    }
}