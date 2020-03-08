import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        int nstar = 1;
        int nrows = n;
        int irow = 1;
        int nspaces = (n-1);
        while(irow<=nrows){
            //Space
            int ispace = 1;
            while(ispace<=nspaces){
                System.out.print(" ");
                ispace++;
            }
            //Hashes
            int istar = 1;
            while(istar<=nstar){
                System.out.print("#");
                istar++;
            }
            //New line
            System.out.println();

            //Preparation
            nstar++;
            nspaces--;

            irow++;
        }


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
