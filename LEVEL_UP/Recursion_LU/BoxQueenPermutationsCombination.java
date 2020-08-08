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
}