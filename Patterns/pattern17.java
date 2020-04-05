            // 		*			
            // 		*	*		
        // *	*	*	*	*	
            // 		*	*		
            // 		*			



import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int nstar=1;
        for (int r = 0; r < n; r++) {
            int istar=1;
            for (int j = 0; j < n; j++) {
              
                if(j>=n/2  && istar<=nstar||r == n/2){
                    System.out.print("*\t");
                    istar++;
                }
                else{
                    System.out.print("\t");
            }
                }
                if(r<n/2){
                    nstar++;
                }else{
                    nstar--;
                }
            System.out.println();
        }

    }
}