/*Question
1. You are given a string str.
2. You are required to find the character with maximum frequency.
Input Format
A string str
Output Format
The character with highest frequency
Constraints
0 < str.length() <= 100
There will be a single character with highest frequency
Sample Input
zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc
Sample Output
q*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character,Integer> freqMap = new HashMap<>();
        
        for(int idx = 0 ; idx<str.length();idx++ ){
            char ch = str.charAt(idx);
            if(freqMap.containsKey(ch)){
                //ch key already exists
                int of = freqMap.get(ch);
                int nf = of+1;
                freqMap.put(ch,nf);
            }else{
                freqMap.put(ch,1);
            }
        }
        
        int mf = Integer.MIN_VALUE;
        char mfc =' ';
        for(Character key: freqMap.keySet()){
            int freq = freqMap.get(key);
            if(freq > mf){
                mf = freq;
                mfc = key;
            }
        }
        System.out.println(mfc);
    }

}