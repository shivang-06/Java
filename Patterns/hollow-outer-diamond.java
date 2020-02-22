            // *	*	*		*	*	*	
            // *	*				*	*	
            // *						*	
            // *	*				*	*	
            // *	*	*		*	*	*	


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int nrow = n;
        int irow = 1;
        int nstar = n/2+1;
        int nspace = 1;
        while (irow <= n) {
            //Stars
            int istar = 1;
            while (istar <= nstar) {
                System.out.print("*\t");
                istar++;
            }

            //Spaces
            int ispace = 1;
            while (ispace <= nspace) {
                System.out.print("\t");
                ispace++;
            }

            //Stars
            istar = 1;
            while (istar <= nstar) {
                System.out.print("*\t");
                istar++;
            }
            
            //New line
            System.out.println();
            
            
            //Preparation
            if(irow<=(n/2)){
                nspace+=2;
                nstar--;
            }else{
                nspace-=2;
                nstar++;
            }
            irow++;


        }
    }
}