            // 1												1	
            // 1	2										2	1	
            // 1	2	3								3	2	1	
            // 1	2	3	4						4	3	2	1	
            // 1	2	3	4	5				5	4	3	2	1	
            // 1	2	3	4	5	6		6	5	4	3	2	1	
            // 1	2	3	4	5	6	7	6	5	4	3	2	1

            import java.util.*;

            public class Main {
            
                public static void main(String[] args) {
                    Scanner scn = new Scanner(System.in);
            
                    // write ur code here
                    int n = scn.nextInt();
            
                    int nrows = n;
                    int nspace = (2 * n - 3);
                    int irow = 1;
                    int nstar = 1;
                    int val = 1;
                    
                    while (irow <= nrows) {
                        int variableSize = nstar;
                        //Star
                        int istar = 1;
                        val = 1;
                        for(istar = 1 ; istar<=variableSize;istar++){
                            System.out.print(val+"\t");
                            val++;
                        }
                        //space
                        int ispace = 1;
                        while (ispace <= nspace) {
                            System.out.print("\t");
                            ispace++;
                        }
                        //Handling last row
                        variableSize = irow==nrows? nstar-1:nstar;
                        val = irow == nrows? val-2:val-1;
                        
                        //star
                        for(istar = 1 ; istar<=variableSize;istar++){
                            System.out.print(val+"\t");
                            val--;
                        }
                        
                        //New Line
                        System.out.println();
                        
                        
                        //Prep
                        irow++;
                        nstar++;
                        nspace = nspace - 2;
                    }
            
                }
            }