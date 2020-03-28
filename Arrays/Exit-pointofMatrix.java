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
        int i = 0;
        int j = 0;
        int dir = 0;
        while (true) {
            dir = (dir + a[i][j]) % 4;
            if (dir == 0) {
                if(j==a[0].length-1){
                    break;
                }
                j++;
            } else if (dir == 1) {
                if(i==a.length-1){
                    break;
                }
                i++;
            } else if (dir == 2) {
                if(j<0){
                    j++;
                    break;
                }
                j--;
            } else if (dir == 3) {
                if(i<0){
                    i++;
                    break;
                }
                i--;
            }
        }
        System.out.println(i);
        System.out.println(j);

    }

}