                                    
                                    // *	*	*	*	*	
                                    // *	*	*	*	
                                    // *	*	*	
                                    // *	*	
                                    // *	

import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
      
           // write ur code here
           int n =scn.nextInt();
           for(int row = n; row>=1;row--){
               for(int col=row; col>=1;col--){
                   System.out.print("*\t");
               }
               System.out.println();
           }
      
       }
      }