import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
                Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<a.length;i++){
            a[i] = sc.nextInt();
        }
        displayArrReverse(a,a.length-1);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        if(idx <0){
            return;
        }
        System.out.println(arr[idx]);
        displayArrReverse(arr,idx-1);

    }

}