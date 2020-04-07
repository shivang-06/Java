/*Question
 1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

                               
Input Format
A number n
Output Format
Contents of the arraylist containing paths as shown in sample output
Constraints
0 <= n <= 10
Sample Input
3
Sample Output
[111, 12, 21, 3]*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList < String > list = getStairPaths(n);
        System.out.println(list);
        
    }
    //Approach 2 using if statements
    public static ArrayList < String > getStairPaths(int n) {
        if (n == 0) {
            ArrayList < String > base = new ArrayList < > ();
            base.add("");
            return base;
        }
        ArrayList < String > finAnswer = new ArrayList < > ();

        if (n - 1 >= 0) {
            ArrayList < String > len1 = getStairPaths(n - 1);
            for (int i = 0; i < len1.size(); i++) {
                finAnswer.add("1" + len1.get(i));
            }

        }
        if (n - 2 >= 0) {
            ArrayList < String > len2 = getStairPaths(n - 2);
            for (int i = 0; i < len2.size(); i++) {
                finAnswer.add("2" + len2.get(i));
            }
        }
        if (n - 3 >= 0) {
            ArrayList < String > len3 = getStairPaths(n - 3);
            for (int i = 0; i < len3.size(); i++) {
                finAnswer.add("3" + len3.get(i));
            }
        }
        return finAnswer;
    }

}