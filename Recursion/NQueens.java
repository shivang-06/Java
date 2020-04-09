/*Question
 1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens
Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

                               
Input Format
A number n
Output Format
Safe configurations of queens as suggested in sample output
Constraints
1 <= n <= 10
Sample Input
4
Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNQueens(new int[n][n], "", 0);
        System.out.println();
    }


    public static boolean isSafe(int[][] chess, int row, int col) {
        // queen can be placed at given row and col or not?

        // check if any queen exist throughout  left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        
        //check if any queen exist at top
        for(int i=row-1;i>=0;i--){
            if(chess[i][col]==1){
                return false;
            }
        }
        
        // check if any queen exist throughout right diagonal
        for (int i = row - 1, j = col +1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        
        //queen can be placed (no queen above can attack)
        return true;

    }

    // qsf -> queen placed so far
    public static void printNQueens(int[][] chess, String qsf, int row) {

        if (row == chess.length) {

            System.out.println(qsf+"."); // solution acquired, all queens placed.

            return;
        }

        for (int col = 0; col < chess[0].length; col++) { // looping through cols of a row!

            if (isSafe(chess, row, col)) {

                chess[row][col] = 1; //indication that queen is placed

                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);

                chess[row][col] = 0; // queen removed during backtracking
            }
        }


    }
}