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
    int value = sc.nextInt();
    int fIdx = -1;
    int lIdx = -1;
    int flag=0;
   
    for(int i = 0 ;i < a.length; i++){
        if(a[i] == value && flag ==0){
            fIdx = i;
            lIdx = i;
            flag =1;
        }
        else if(a[i]==value && flag!=0){
            lIdx = i;
        }
    }

    
    System.out.println(fIdx);
    System.out.println(lIdx);
    
    
 }

}