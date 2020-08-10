import java.util.*;
public class BoxQueenPermutationsCombination{
    public static void main(String[] args) {
        // int[] coins = {2,3,5,7};
        // boolean[][] box = new boolean[6][6];
        // System.out.println(twoDNQueenFloorWise(box,0,3,0,""));
        wordBreak();
    }
    public static int BoxQueenPermu(boolean[] box,int idx,int tnq,int qpsf,String ans){
        if(qpsf == tnq ){
            System.out.println(ans);
            return 1;
        }
       
        int count = 0;
        for(int i = idx ;i <box.length;i++){
            if(!box[i]){
                box[i] = true;
                count+=BoxQueenPermu(box,idx,tnq,qpsf+1,ans + "b" +i + "q" +qpsf+" ");
                box[i] = false;
            }
        }
        return count;
    }
    // public static int BoxQueenCombi(int[] q, int[] space,int sidx) {
        
        
    //     BoxQueenCombi(q,space,sidx+1);
    //     BoxQueenCombi(q,space,sidx);
    // }

    public static int coinChangeInfinitePermutations(int[] arr,int idx,int tar,String ans){
        if(tar == 0 || idx == arr.length){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = idx;i<arr.length;i++){
            if(tar-arr[i] >=0 )
            count+= coinChangeInfinitePermutations(arr,idx,tar-arr[i],ans+arr[i]);
        }
        return count;
    }
    public static int twoDNQueenFloorWise(boolean[][] box,int row,int tnq,String ans){
        if(tnq == 0 || row == box.length){
            if(tnq == 0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int m = box[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            count+=twoDNQueenFloorWise(box,row+1,tnq-1,ans+"("+row+", "+i+") ");
        }
        return count;
    }
    // geeksfor geeks = WordBreak questiion ====================================
    public static int  wordBreak(String ques,int idx,String ans,int maxLenWord, HashSet<String> words ) {
        if(idx == ques.length()){
            System.out.println(ans);
            return 1;
        }
        int count =0;
        for(int i=idx;i<=(idx+maxLenWord+1) && i<=ques.length(); i++){
            String str = ques.substring(idx,i);
            if(words.contains(str)){

                count+= wordBreak(ques,i,ans+str+" ",maxLenWord,words);
            }
        }
        return count;
    }
    public static void  wordBreak() {
        String ques = "ilikesamsungandmango";
        String[] word = {"mobile","samsung","sam","sung","man","mango","icecream","and","go","i","like","ice","cream","ilike"};

        HashSet<String> words = new HashSet();
        int maxLenWord = 0;
        for(String s:word){
            maxLenWord = Math.max(maxLenWord,s.length());
            words.add(s);
        }
        System.out.println(wordBreak(ques,0,"",maxLenWord,words));
    }

    //cryptarithmatice ======================================
    static string a = "send"; 
    static string b = "more"; 
    static string c = "money";
    static int[] charToNumber = new int[26];
    static boolean[] numberUsed = new boolean[10];

    public static int  stringToNumber(String s){
        int num=0;
        for(int i =0;i<str.length();i++){
            char ch = s.charAt(i);
            int val = charToNumber[ch-'a'];

            num = num*10 + val;
        }
        return num;
    }
    public static int cryptoSolver(String str,int idx){
        if(idx == str.length()){
            int x = stringToNumber(a);
            int y = stringToNumber(b);
            int c = stringToNumber(c);
            if(x+y == z && charToNumber[a.charAt(0)-'a']!=0 && charToNumber[b.charAt(0)-'a']!=0 && charToNumber[c.charAt(0)-'a']!=0){
                System.out.println(x + "\n +"+y+"\n"+"----\n"+z+"\n");
                return 1;
            }
            return 0;
        }

        char ch = str.charAt(idx);
        int count = 0;
        for(int num=0;num<9;num++){
            if(!numberUsed[num]){
                numberUsed[num] = true;
                charToNumber[ch-'a'] = num;
                count+=cryptoSolver(str,idx+1);
                charToNumber[ch-'a'] = 0;
                numberUsed[num] = false;

            }
        }
        return count;

    }


    public static boolean isCryptoValid() {
        String str = a+b+c;
        int[] freq = new int[26];
        for(int i=0;i<str.length();i++){
            freq[str.charAt(i)-'a']++;
        }        
        str = "";
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                str +=(char)(i+'a');
            }
        }

    } 
}