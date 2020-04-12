/*Question
1. Here are a few sets of inputs and outputs for your reference
Input1 -> 1
Output1 -> 1 

Input2 -> 3
Output2 -> 1 2 1 3 1 2 1 

2. Figure out the pattern and complete the recursive function to achieve the above for any positive number n.
Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format

a number ,n

Constraints

n > 0

Output Format

series of numbers speprated by space

Sample Input 0

1
Sample Output 0

1
Sample Input 1

3
Sample Output 1

1 2 1 3 1 2 1 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
    }
    public static void print(int n){
        if(n == 1){
            System.out.print(n+" ");
            return;
        }
        
        print(n-1);
        System.out.print(n+" ");
        print(n-1);
        
    }
}