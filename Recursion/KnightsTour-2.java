/*Question
   1. You are given a number n, the size of a chess board.
2. You are given a row and a column, as a starting point for a knight piece.
3. You are required to generate the all moves of a knight starting in (row, col) such that knight visits all cells of the board exactly once.
3. Complete the body of printKnightsTour function - without changing signature - to calculate and print all configurations of the chess board representing the route
of knight through the chess board. Use sample input and output to get more idea.

Note -> When moving from (r, c) to the possible 8 options give first precedence to (r - 2, c + 1) and move in clockwise manner to
explore other options.
Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
 
                               
                               
                               
                               
Input Format
A number n
A number row
A number col
Output Format
All configurations of the chess board representing route of knights through the chess board starting in (row, col)
Use displayBoard function to print one configuration of the board.
Constraints
n = 5
0 <= row < n
0 <= col < n
Sample Input
5
2
2
Sample Output
21 12 7 2 19 
6 17 20 13 8 
11 22 1 18 3 
16 5 24 9 14 
23 10 15 4 25 

23 12 7 2 25 
6 17 24 13 8 
11 22 1 18 3 
16 5 20 9 14 
21 10 15 4 19 

.. and so on, all such configurations*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        printKnightsTour(new int[n][n], r, c, 1);
        System.out.println();
    }

    public static void printKnightsTour(int[][] chess, int row, int col, int move) {
        
        //invalid condition
        if (row < 0 || col < 0 || row >= chess.length || col >= chess[0].length||chess[row][col]!=0) {
           //visited block has been revisited again + invalid index
            return;
        }

        // base condition
        if (move == chess.length * chess[0].length) {
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }
        //Setting move value at chess board blocks
        chess[row][col] = move;
        //move 1
        printKnightsTour(chess, row - 2, col + 1, move + 1);
        //move 2
        printKnightsTour(chess, row - 1, col + 2, move + 1);
        //move 3
        printKnightsTour(chess, row + 1, col + 2, move + 1);
        //move 4
        printKnightsTour(chess, row + 2, col + 1, move + 1);
        //move 5
        printKnightsTour(chess, row + 2, col - 1, move + 1);
        //move 6
        printKnightsTour(chess, row + 1, col - 2, move + 1);
        // move 7
        printKnightsTour(chess, row - 1, col - 2, move + 1);
        // move 8
        printKnightsTour(chess, row - 2, col - 1, move + 1);

        chess[row][col] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}