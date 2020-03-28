
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
        //Approach 2
        int i = 0;
        int j = 0;
        int dir = 0;
        while (true) {
            dir = (dir + a[i][j]) % 4;
            if (dir == 0) {
                j++;
            } else if (dir == 1) {
                i++;
            } else if (dir == 2) {
                j--;
            } else if (dir == 3) {
                i--;
            }
            if(i<0){
                i++;
                break;
            }if(j<0){
                j++;
                break;
            }if(i>=a.length){
                i--;
                break;
            }if(j>=a[0].length){
                j--;
                break;
            }
            
        }
        System.out.println(i);
        System.out.println(j);

    }

}