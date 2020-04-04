/*Question
 1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of printStairPaths function - without changing signature - to print the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

                               
Input Format
A number n
Output Format
Print paths (one path in each line) in order hinted by Sample output
Constraints
0 <= n <= 10
Sample Input
3
Sample Output
111
12
21
3*/
//Check 3 approaches
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String path = "";
        printStairPathsPre(n, path);
        // printStairPathsPost(n, path);
    }
    
    
    public static void printStairPathsPost(int n, String path) {

        String one = "1";
        String two = "2";
        String three = "3";
        if(n<0){
            //invalid spot
            return;
        }
        if (n <= 0) {
            System.out.println(path);
            return;
        }

        //Approach - 3
        //1-length

        printStairPathsPost(n - 1, path + one);
        //2-length

        printStairPathsPost(n - 2, path + two);
        //3-length

        printStairPathsPost(n - 3, path + three);





    }

    public static void printStairPathsPre(int n, String path) {

        String one = "1";
        String two = "2";
        String three = "3";
        if (n <= 0) {
            System.out.println(path);
            return;
        }

        // if (n - 1 >= 0) {
        //     printStairPaths(n - 1, path + one);
        // }

        // if (n - 2 >= 0) {
        //     printStairPaths(n - 2, path + two);
        // }

        // if (n - 3 >= 0) {
        //     printStairPaths(n - 3, path + three);
        // }


        //Approach - 2 
        //1-length
        if (n - 1 >= 0) {
            printStairPathsPre(n - 1, path + one);
            //2-length
            if (n - 2 >= 0) {
                printStairPathsPre(n - 2, path + two);
                //3-length
                if (n - 3 >= 0) {
                    printStairPathsPre(n - 3, path + three);
                }

            }

        }
    }
}