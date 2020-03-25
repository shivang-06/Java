import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    int maxId = 0;
    int max = Integer.MIN_VALUE;
    for(int i = 0 ; i<arr.length ; i++){
        arr[i] = sc.nextInt();
        if(max<arr[i]){
            max = arr[i];
        }
    }
    // int curr =max;
    for(int i=0;i<max;i++){
        for(int j =0;j<arr.length;j++){
            if(arr[j] >= max){
                System.out.print("*\t");
            }else{
                System.out.print("\t");
            }
            arr[j]++;
        }
        System.out.println();
        // curr--;
    }
}

}