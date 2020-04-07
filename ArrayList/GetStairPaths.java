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

    public static ArrayList < String > getStairPaths(int n) {
        ArrayList < String > finAnswer = new ArrayList < > ();
        //invalid point
        if (n < 0) {
            ArrayList < String > invalid = new ArrayList < > ();
            return invalid;
        }
        //base case || end result achieved
        if (n == 0) {
            ArrayList < String > base = new ArrayList < > ();
            base.add("");
            return base;
        }

        for (int i = 1; i <= 3; i++) {
            ArrayList < String > answer = getStairPaths(n - i);
            
            for (String val: answer) {
                finAnswer.add(i + val);
            }
        }

        return finAnswer;
    }

}