/*Question
 1. You are given a string str.
2. Complete the body of printSS function - without changing signature - to calculate and print all subsequences of str.
Use sample input and output to take idea about subsequences.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

                               
Input Format
A string str
Output Format
Subsequences of str in order hinted by Sample output
Constraints
0 <= str.length <= 7
Sample Input
abc
Sample Output
c
b
bc
a
ac
ab
abc*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String asf = "";
        printSS(str, asf);
        System.out.println();
    }

    public static void printSS(String str, String asf) {
        if (str.length() == 0) {
            if(asf.length()!=0)
            System.out.println(asf);
            
            return;
        }
        char ch = str.charAt(0);
        
        String restQues = str.substring(1);
        
        // not to be included in answer
        printSS(restQues, asf);
        
        //to be included in answer
        printSS(restQues, asf+ch);
    }

}