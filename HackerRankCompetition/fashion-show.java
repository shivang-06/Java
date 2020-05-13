/*
mr. pepper has a very weird, fashion sense(as given below). 

Suppose you are given n elements in an array, thus elements should follow a 
fashion(discipline).

ele1 < ele2 > ele3 < ele4 > ele5 ........ (upto nth element).

your task is to re-arrange the "DISTINCT" elements of array in proper fashion in O(n) time.
The converted array should be in form a < b > c < d > e < f.

Example : 
input {5, 4, 3, 2}
output {4, 5, 2, 3}
Input Format

1. N (a number, representing size of input)
2. ele1 , ele2 , ele3 , ...... elen ( N more inputs,elements)
Constraints

0 <= N <= 100,000
Output Format

space seperated array elements(following proper fashion/discipline).
Sample Input 0

4
5 4 3 2
Sample Output 0

4 5 2 3
Sample Input 1

7
3 -1 5 8 6 2 1
Sample Output 1

-1 5 3 8 2 6 1*/

import java.io.*;
import java.util.*;

public class Solution {
 public static void main(String[] args)  
    { 
        
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        boolean f = true; 
          
        int temp =0; 
       
        for (int i=0; i<=arr.length-2; i++) 
        { 
            if (f){ 
                if (arr[i] > arr[i+1]){ 
                    temp  = arr[i]; 
                    arr[i] = arr[i+1]; 
                    arr[i+1] = temp; 
                } 
            } 
            else{ 
                if(arr[i] < arr[i+1]){
                    temp = arr[i]; 
                    arr[i] = arr[i+1]; 
                    arr[i+1] = temp; 
                } 
            } 
            f = !f; 
        } 
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        
        
    } 
}