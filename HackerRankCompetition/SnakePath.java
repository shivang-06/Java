/*Question
1.Take as input N, a number. N is the size of a snakes and ladder board (without
any snakes and ladders).
2.Take as input M, a number. M is the number of faces of the dice.

a. Write a recursive function which returns the count of different ways the
board can be travelled using the dice. Print the value returned.

b. Write a recursive function which returns an ArrayList of dice values for all
valid paths across the board. Print the value returned.

c. Write a recursive function which prints dice-values for all valid paths across
the board (void is the return type for function).
Input Format

Integer Input
Constraints

1<= n <=1000000000
Output Format

print the output.
Sample Input 0

5
6
Sample Output 0

16
[11111, 1112, 1121, 113, 1211, 122, 131, 14, 2111, 212, 221, 23, 311, 32, 41, 5]
11111
1112
1121
113
1211
122
131
14
2111
212
221
23
311
32
41
5*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
            Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
        int m=sc.nextInt();
      ArrayList<String> result=getStair(n,m);
        System.out.println(result.size());
      System.out.println(result);
        for (int i = 0; i < result.size();i++)
          {              
              System.out.println(result.get(i));        
          }  
    }

    public static ArrayList<String> getStair(int n,int m) {
         if(n==0)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
       
       
        ArrayList<String> result=new ArrayList<String>();
       for(int i=1;i<=m;i++){
       if(n-i>=0)
       {
           ArrayList<String> len1=getStair(n-i,m);
           for(String val:len1)
           {
               result.add(i+val);
           }
         }
       }
               
     
         return result;
    }

}
