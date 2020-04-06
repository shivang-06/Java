/*Question
 1. You are given a string str.
2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
Use sample input and output to take idea about subsequences.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

                               
Input Format
A string str
Output Format
Contents of the arraylist containing subsequences as shown in sample output
Constraints
0 <= str.length <= 20
Sample Input
abc
Sample Output
[, c, b, bc, a, ac, ab, abc]*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList < String > list = gss(str);
        System.out.println(list);
    }

    public static ArrayList < String > gss(String str) {
        if (str.length() == 0) {
            ArrayList < String > base = new ArrayList < String > ();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        String rem = str.substring(1);
        ArrayList < String > answer = gss(rem);
        ArrayList < String > finAnswer = new ArrayList < > ();
        
        //ch not included 
        for (String val: answer) {
            finAnswer.add(val);
        }
        //ch included
        for (String val: answer) {
            finAnswer.add(ch+val);
        }

        return finAnswer;
    }

}