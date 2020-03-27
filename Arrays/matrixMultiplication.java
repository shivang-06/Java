import java.io.*;
import java.util.*;

public class Main{
public static int[][] insert(int [][]a , Scanner sc,int n, int m ){
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            a[i][j] = sc.nextInt();
        }
    }
    return a;
}

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n1 =sc.nextInt();
    int m1 = sc.nextInt();
    int [][]arr1 = new int[n1][m1];   
    arr1 = insert(arr1 , sc, n1,m1);
    int n2 =sc.nextInt();
    int m2 = sc.nextInt();
    int [][]arr2 = new int[n2][m2]; 
    arr2 = insert(arr2,sc,n2,m2);
    int [][]mult = new int[n1][m2];
    
    if(arr1[0].length != arr2.length){
        System.out.println("Invalid input");
        return;
    }    
    for(int i=0 ; i<n1 ; i++){
        for(int j=0;j<m2;j++){
            for(int k=0;k<m1;k++){
                mult[i][j] += arr1[i][k] * arr2[k][j];
            }
        }        
    }
    for(int i=0;i<n1;i++){
        for(int j=0;j<m2;j++){
            System.out.print(mult[i][j]+" ");
        }
        System.out.println();
    }
    
 }

}