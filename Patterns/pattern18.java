                // *	*	*	*	*	*	*	
                    // 	*				*	
                    // 		*		*	
                    // 			*	
                    // 		*	*	*	
                    // 	*	*	*	*	*	
                // *	*	*	*	*	*	*	

import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
      
           // write ur code here
           int n = scn.nextInt();
           int nrows = n;
           int irow = 1;
           int nstar = n;
           int nspace = 0;
           while(irow<=nrows){
               //Space
               int ispace = 1;
               while(ispace<=nspace){
                   System.out.print("\t");
                   ispace++;
               }
               //Star
               int istar = 1;
               while(istar<=nstar){
                   if(irow>1 &&irow<nrows/2+1 && istar>1 && istar < nstar ){
                       System.out.print("\t");
                   }
                   else{
                       
                   System.out.print("*\t");
                   }
                   istar++;
               }
               //New line
               System.out.println();
               //prep
               if(irow<=((nrows/2))){
                   nspace++;
                   nstar = nstar-2;
                   
               }else{
                   nspace--;
                   nstar = nstar+2;
                   
               }
               
               irow++;
               
           }
           
      
       }
      }