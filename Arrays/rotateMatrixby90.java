import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        rotateby90(a);
        display(a);


    }
    public static void rotateby90(int[][] a) {
        //Transpose
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <=i; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        
        // reverse col elements
        for(int row = 0 ; row<a.length;row++){
            int start = 0;
            int end = a[0].length-1;
            while(start<end){
                int temp = a[row][start];
                a[row][start] = a[row][end];
                a[row][end] = temp;
                end--;
                start++;
            }
        }

    }

    public static void display(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}