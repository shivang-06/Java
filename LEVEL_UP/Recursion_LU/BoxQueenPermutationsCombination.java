public class BoxQueenPermutationsCombination{
    public static void main(String[] args) {
        int[] coins = {2,3,5,7};
        boolean[][] box = new boolean[6][6];
        System.out.println(twoDNQueenFloorWise(box,0,3,0,""));
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
        return count
    }
    // geeksfor geeks = WordBreak questiion ====================================
    public static int  wordBreak(String ques,int idx,String ans,int maxLenWord, HashSet<String> words ) {
        if(idx == ques.length()){
            System.out.println(ans);
            return 1;
        }
        for(int i=idx;i<=(idx+maxLenWord+1) && i<=ques.length(); i++){
            String str = ques.substring(idx,i);
            if(words.contains(str)){

                count+= wordBreak(ques,i,ans+str+" ",maxLenWord,words);
            }
        }
        return count;
    }
    public static int  wordBreak() {
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
}