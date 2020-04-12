/*Check whether all points lie ona horizontal or vertical line ?
print "YES" if all points lie on the line & "NO" otherwise.
Input Format

1. a number n
2. n more inputs representing co-ordinates
	x y (format)
Constraints

n > 0 xi,yi > 0

Output Format

"YES" if all points lie on the line & "NO" otherwise
Sample Input 0

5
0 1
0 2
1 3
0 4
0 5
Sample Output 0

NO*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
   Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        int x1=0;
        int y1=0;
        int count=0;
        int count1=0;
        
        for(int i=2;i<=t;i++)
        {   
            x1=sc.nextInt();
            y1=sc.nextInt();
            if(x!=x1)
            {   count++;
                
            }
            if(y!=y1)
            {
                count1++;
            }
        }
    
      if(count==0||count1==0)
      {
          System.out.println("YES");
      }
        else{
            System.out.println("NO"); 
        }
        
    
    
    }
}
