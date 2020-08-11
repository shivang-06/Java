public class ValidSudoku{
    public static void main(String[] args) {

        solveSoduku(); //leetcode 36
    }

    public static int solveSoduku(int[][] board,int vidx) {
        if(vidx == 81){

            return 1;
        }
        int r = vidx/9;
        int c = vidx%9;
        if(board[r][c]!=) return solveSoduku(board,vidx+1);

        int count = 0;
        for(int num=1;num<=9;num++){
            if(isValidToPlaceNumber(board,r,c,num)){
                board[r][c] = num;
                count+=solveSoduku(board,vidx+1); 
                board[r][c] = 0;
            }
        }
    }
    public static boolean isValidToPlaceNumber(int[][] board,int r,int c,int num) { //helper fn of sudoku solver
        //to check row
        for(int i=0;i<9i++){
            if(board[r][i] == num ) return false;            
        }

        //to check col
        for(int i=0;i<9i++){
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
}