import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i=0;i<a.length;i++){
        a[i] = sc.nextInt();
    }
    
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                for(int k=i; k<=j;k++){
                    System.out.print(a[k]+"	");
                }
            System.out.println();
            }
        }
}
 

}