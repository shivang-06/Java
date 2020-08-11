import java.util.*;
public class ValidSudoku{
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0, 0},  
                      {0, 0, 0, 0, 0, 0, 0, 0, 0},  
                      {0, 8, 7, 0, 0, 0, 0, 0, 0},  
                      {0, 0, 3, 0, 1, 0, 0, 8, 0},  
                      {9, 0, 0, 8, 6, 3, 0, 0, 5},  
                      {0, 5, 0, 0, 9, 0, 6, 0, 0},  
                      {1, 3, 0, 0, 0, 0, 2, 5, 0},  
                      {0, 0, 0, 0, 0, 0, 0, 7, 4},  
                      {0, 0, 5, 2, 0, 6, 3, 0, 0}}; 

        System.out.println(sudoku()); //leetcode 36
        // System.out.println(solveSoduku(board,0));
    }


    public static int solveSoduku(int[][] board,int vidx) {
        if(vidx == 81){
            displayBoard(board);
            return 1;
        }
        int r = vidx/9;
        int c = vidx%9;
        if(board[r][c]!= 0) return solveSoduku(board,vidx+1);

        int count = 0;
        for(int num=1;num<=9;num++){
            if(isValidToPlaceNumber(board,r,c,num)){
                board[r][c] = num;
                count+=solveSoduku(board,vidx+1); 
                board[r][c] = 0;
            }
        }
        return count;
    }
    public static boolean isValidToPlaceNumber(int[][] board,int r,int c,int num) { //helper fn of sudoku solver
        //to check row
        for(int i=0;i<9;i++){
            if(board[r][i] == num ) return false;            
        }

        //to check col
        for(int i=0;i<9;i++){
            if(board[i][c] == num ) return false;            
        }

        //check matrix of 3x3
        r = (r/3)*3;
        c = (c/3)*3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[r+i][c+j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    public static void displayBoard(int[][] board) {
        for(int[] a:board){
            display(a);
        }
        System.out.println();
    }
    public static void display(int[] board) {
        for(int a:board){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    //Better approach to Solvesudoku
    public static int solveSoduku_02(int[][] board,int vidx,ArrayList<Integer> locOfZeros) {
        if(vidx == locOfZeros.size()){
            displayBoard(board);
            return 1;
        }
        int twoDloc = locOfZeros.get(vidx);
        int r = twoDloc / 9;
        int c = twoDloc % 9;

        int count = 0;
        for(int num=1;num<=9;num++){
            if(isValidToPlaceNumber(board,r,c,num)){
                board[r][c] = num;
                count+=solveSoduku_02(board,vidx+1,locOfZeros); 
                board[r][c] = 0;
            }
        }
        return count;
    }

    public static int sudoku(){
        int[][] board = {{3, 0, 0, 6, 0, 0, 0, 9, 2},  
                      {5, 2, 0, 0, 0, 0, 4, 0, 8},  
                      {0, 8, 7, 0, 0, 0, 0, 3, 1},  
                      {0, 0, 3, 0, 1, 0, 0, 8, 0},  
                      {9, 0, 0, 8, 6, 3, 0, 0, 5},  
                      {0, 5, 0, 0, 9, 0, 6, 0, 0},  
                      {1, 3, 0, 0, 0, 0, 2, 5, 0},  
                      {0, 0, 0, 0, 0, 0, 0, 7, 4},  
                      {0, 0, 5, 2, 0, 6, 3, 0, 0}};



        ArrayList<Integer> locOfZeros = new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == 0){
                    locOfZeros.add( i*9 + j);
                }
            }
        }
        return solveSoduku_02(board,0,locOfZeros);
    }

}