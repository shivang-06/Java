import java.io.*;
import java.util.*;

public class Main {

    public static int[] binary(int a, int n) {
        int[] binaryArr = new int[n];
        int pos = n - 1;
        while (a != 0) {
            binaryArr[pos] = a % 2;
            pos--;
            a /= 2;
        }
        return binaryArr;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int N = (int) Math.pow(2, n);
        for (int i = 0; i < N; i++) {
            int[] temp = binary(i, n);
            for (int j = 0; j < temp.length; j++) {
                    if(temp[j] == 1){
                        System.out.print(arr[j]+"	");
                    }else{
                        System.out.print("-	");
                    }
            }
            System.out.println();
        }




    }

}