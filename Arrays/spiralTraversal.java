import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int rowMin = 0, rowMax = n - 1;
        int colMin = 0, colMax = m - 1;
        int count = 0;
        while (count < n * m) {
            //print left wall
            for (int i = rowMin; i <= rowMax; i++) {
                System.out.println(a[i][colMin]);
                count++;
            }
            colMin++;

            //print bottom wall
            for (int j = colMin; j <= colMax && count < n * m; j++) {
                System.out.println(a[rowMax][j]);
                count++;
            }
            rowMax--;

            //print right wall
            for (int i = rowMax; i >= rowMin && count < n * m; i--) {
                System.out.println(a[i][colMax]);
                count++;
            }
            colMax--;

            //print top wall
            for (int j = colMax; j >= colMin && count < n * m; j--) {
                System.out.println(a[rowMin][j]);
                count++;
            }
            rowMin++;
        }



    }


}