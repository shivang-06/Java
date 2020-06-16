/*Mr.Sunny Singh works in a Rangoli Design company. One day, he designed a Rangoli with the following specifications:

> Rangoli size must be N X M. ( N is an odd natural number, and M is 3 times N.)
> The design should have 'WELCOME' written in the center.
> The design pattern should only use |, . and - characters.
Input Format

a number n 
a number m
Constraints

normal
Output Format

pattern banana hai bhyi !!!
Sample Input 0

7 21
Sample Output 0

---------.|.---------
------.|..|..|.------
---.|..|..|..|..|.---
-------WELCOME-------
---.|..|..|..|..|.---
------.|..|..|.------
---------.|.---------
Contest ends in an hour
Submissions: 33
Max Score: 40
Difficulty: Medium
Rate This Challenge:

    
More
*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ndash = (m-3)/2;
        int npat = 1;
        for(int i=0; i<n; i++){
            if(i == (n/2)){
                int dash = (m-7)/2;
                int idash = 1;
                while(idash <= dash){
                System.out.print("-");
                idash++;
            }
                System.out.print("WELCOME");
                int jdash=1;
                while(jdash <= dash){
                System.out.print("-");
                jdash++;
            }
                npat -= 2;
                ndash += 3;
            }else{
            int idash=1;
            while(idash <= ndash){
                System.out.print("-");
                idash++;
            }
            int ipat = 1;
            while(ipat <= npat){
                System.out.print(".|.");
                ipat++;
            }
            int jdash = 1;
            while(jdash <= ndash){
                System.out.print("-");
                jdash++;
            }
            if(i < n/2){
                npat += 2;
                ndash -= 3;
            }else{
                npat -= 2;
                ndash += 3;
            }
            }
            System.out.println();
        }
    }
}
