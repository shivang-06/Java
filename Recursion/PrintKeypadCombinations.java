/*Question
   1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
2. The following list is the key to characters map
0 -> .;
1 -> abc
2 -> def
3 -> ghi
4 -> jkl
5 -> mno
6 -> pqrs
7 -> tu
8 -> vwx
9 -> yz
3. Complete the body of printKPC function - without changing signature - to print the list of all words that could be produced by the keys in str.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

                               
                               
                               
Input Format
A string str
Output Format
Words that can be produced by pressed keys indictated by str in order hinted by Sample output
Constraints
0 <= str.length <= 10
str contains numbers only
Sample Input
78
Sample Output
tv
tw
tx
uv
uw
ux*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printKPC(str, "");

    }

    static String[] keypad = {
        ".;", //0
        "abc", //1
        "def", //2
        "ghi", //3
        "jkl", //4
        "mno", //5
        "pqrs", //6
        "tu", //7
        "vwx", //8
        "yz" //9
    };

    public static void printKPC(String qsf, String asf) {
        //Base Condition
        if (qsf.length() == 0) {
            System.out.println(asf);
            return;
        }
        //Taking each character of string at a time  
        char ch = qsf.charAt(0);
        qsf = qsf.substring(1); // Preparing rest of the string
        int idx = Integer.parseInt("" + ch); // creating index for traversing keypad

        String temp = keypad[idx]; // Storing string retrieved from array.

        for (int i = 0; i < temp.length(); i++) {
            printKPC(qsf, asf + temp.charAt(i)); //recursive call
        }
    }

}