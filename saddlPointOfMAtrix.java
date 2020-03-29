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
        saddlePoint(a);

        


    }
    public static void saddlePoint(int a[][]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            
            //Find minimum element
            int min = a[i][0];
            int minCol = 0;
            for(int j =1 ;j<n;j++){
                if(a[i][j]<min){
                    min = a[i][j];
                    minCol = j;
                }
            }
            
            //Check if minimum ele maximum in its column
            boolean flag = true;
            for(int k = 0;k<n;k++){
                if(a[k][minCol]>a[i][minCol]){
                    flag  = false;
                }
                
            }
            if(flag == true){
                System.out.println(a[i][minCol]);
                return;
            }
        }
        System.out.println("Invalid input");
    }

}