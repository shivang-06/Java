import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double division =0;
        double cPos =0;
        double cNeg =0;
        double cZer=0;
        double size = arr.length;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                cPos++;
                
            }else if(arr[i]==0){
                cZer++;
            }
            else{
                cNeg++;
            }

        }

        double PosDiv = cPos/size;
        
        System.out.println(PosDiv);
        double NegDiv = cNeg/size;
        System.out.println(NegDiv);
        double ZerDiv = cZer/size;
        System.out.println(ZerDiv);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
