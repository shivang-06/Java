import java.util.*;

public class SumofTwoARray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] sum = new int[n1>n2? n1 : n2];
        int i = n1 - 1;
        int j = n2 - 1;
        int k = sum.length-1;
        int carry = 0;
        while(k>=0){
            int value = carry;
            if(i>=0){
                value += arr1[i];
            }
            if(j>=0){
                value += arr2[j];
            }
            carry = value / 10;
            value = value%10;
            sum[k] = value;
            i--;
            j--;
            k--;
            
        }
        if(carry !=0){
            System.out.println(carry);
        }
        for(int f = 0 ; f<sum.length;f++){
            System.out.println(sum[f]);
        }

            
    }

}