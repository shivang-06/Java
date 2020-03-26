import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = sc.nextInt();
        }
        
        int n2 = sc.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = sc.nextInt();
        }
        
        int borrow = 0;
        
        int[] diffArr = new int[n2];
        
        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = diffArr.length - 1;
        while (k >= 0) {
            int iVal = 0;
            int diff = 0;
            if (i >= 0) {
                iVal = a1[i];
            }

            if (a2[j] - borrow >= iVal) {
                diff = a2[j] - iVal - borrow;
                borrow = 0;
            } else {
                diff = a2[j] - iVal - borrow + 10;
                borrow = 1;
            }

            diffArr[k] = diff;
            i--;
            j--;
            k--;
        }

        int flag = 0;
        for (int z = 0; z < diffArr.length; z++) {
            if (flag == 0 && diffArr[z] == 0) {
                continue;
            }
            flag = 1;
            System.out.println(diffArr[z]);
        }
    }

}