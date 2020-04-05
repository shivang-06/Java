                        // 			*	
                        // 		*		*	
                        // 	*				*	
                       // *						*	
                        // 	*				*	
                        // 		*		*	
                        // 			*	


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int nrows = n;
        int irow = 1;
        int nstar = 1;
        int nspace = n / 2;

        while (irow <= nrows) {
            //Spaces
            int ispace = 1;
            while (ispace <= nspace) {
                System.out.print("\t");
                ispace++;
            }
            //Stars
            int istar = 1;
            while (istar <= nstar) {
                if(irow>1 && irow<nrows && istar>1 && istar < nstar){
                    System.out.print("\t");
                }
                else{
                    
                System.out.print("*\t");
                }
                istar++;
            }
            //new line
            System.out.println();
            //prep
            if (irow <= nrows / 2) {
                nstar = nstar + 2;
                nspace--;
            } else {
                nspace++;
                nstar = nstar - 2;
            }

            irow++;
        }

    }
}