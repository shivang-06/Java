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
        for (int gap = 0; gap < n; gap++) {

            for (int i = 0, j = gap; i < n && j < n; i++, j++) {
                System.out.println(a[i][j]);

            }
        }

    
}
}