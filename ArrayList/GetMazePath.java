/*Question
 1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

                               
Input Format
A number n
A number m
Output Format
Contents of the arraylist containing paths as shown in sample output
Constraints
0 <= n <= 10
0 <= m <= 10
Sample Input
2
2
Sample Output
[hv, vh]*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<String> list = getMazePaths(0,0,n-1,m-1);
        System.out.println(list);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        ArrayList<String> finAnswer = new ArrayList<>();
        if(sr == dr && sc == dc){
            ArrayList<String> base =  new ArrayList<>();
            base.add("");
            return base;
        }
        if(sc+1<=dc){
            ArrayList<String> answerCol = getMazePaths(sr,sc+1,dr,dc);
            for(String val: answerCol){
                finAnswer.add("h"+val);
            }
            
        }
        
        if(sr+1<=dr){
            ArrayList<String> answerRow = getMazePaths(sr+1,sc,dr,dc);
            for(String val: answerRow){
                finAnswer.add("v"+val);
            }
        }
        return finAnswer;
    }

}