import java.io.*;
import java.util.*;

public class Main{


  public static int[] inverse(int[] a){
    // write your code here
        int size = a.length;
    int[] temp = new int[size];
    for(int i = 0 ;i <a.length; i++){
        int tempVal = a[i];
        temp[tempVal] = i;
    }
    return temp;
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] inv = inverse(a);
    for(int i = 0; i< inv.length;i++){
        System.out.println(inv[i]);
    }
 }

}