import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = sc.nextInt();
        // }
        // int min = arr[0];
        // int max = arr[0];
        // for(int i = 0; i<arr.length;i++){
        //     if(arr[i]<min){
        //         min = arr[i];
        //     }else if(arr[i]>max){
        //         max = arr[i];
        //     }
        // }
        // int sapn = max-min;
        // System.out.println(span);

        //Approach 2 - with single loop
        int n = sc.nextInt();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        // System.out.println(min);
        int max = Integer.MIN_VALUE;
        // System.out.println(max);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            
            if (min>arr[i]) {
                min = arr[i];
            } else if (max < arr[i]) {
                max = arr[i];
            }
        }
        int span = max - min;
        System.out.println(span);
    }

}