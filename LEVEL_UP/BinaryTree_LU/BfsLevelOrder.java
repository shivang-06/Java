import java.util.*;
public class BfsLevelOrder {
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        solve();
    }
    public static void solve(){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = constructTree(arr);
        allSolutionPair pair = new allSolutionPair();
        allSolution(root,0,80,pair);
    }
    public static Node constructTree(int[] arr){
        if(idx==arr.length || arr[idx]==-1){
            idx++;
            return null;
        }

        Node node=new Node(arr[idx++]);

        node.left = constructTree(arr);
        node.right = constructTree(arr);

        return node;
    }
    public static void display(Node node){
        if(node==null) return;
        StringBuilder sb = new StringBuilder();
        
        sb.append(node.left!=null?node.left.data+"" : ".");
        sb.append(" <- " + node.data + " -> ");
        sb.append(node.right!=null?node.right.data+"" : ".");

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);
    }
    public static int width(Node node,int level,int[] minMax){
        if(node == null) return 0;
        minMax[0] = Math.min(minMax[0],level);
        minMax[1] = Math.max(minMax[1],level);
        width(node.left,level-1,minMax);
        width(node.right,level+1,minMax);
        return minMax[1] - minMax[0];
    }
    
    public static class vPair{ // vertical pair
        Node node = null;
        int level = 0;
        public vPair(){
            this.node = node;
            this.level = level;
        }
    }
    public static void VerticalOrder(Node node){
        int[] minMax = new int[2];
        width(node,0,minMax);

    }

    //predecessor & successor of Binay tree.

    public static class allSolutionPair{
        int height = 0;
        int size = 0;
        boolean find = false;

        int ceil = (int)1e8; // Integer.MAX_VALUE
        int floor = -(int)1e8; // Integer.MIN_VALUE

        Node pred = null,succ = null,prev = null;
    }
    public static void allSolution(Node node,int level,int target,allSolutionPair pair){
        if(node == null) return;
        pair.height = Math.max(pair.height,level);
        pair.size++;
        pair.find = pair.find || node.data == target;

        if(node.data > target) pair.ceil = Math.min(pair.ceil,node.data);

        if(node.data < target) pair.floor = Math.max(pair.floor,node.data);
        
        allSolution(node.left,level+1,target,pair);
        //inorder predecessor & successsor
        if(node.data == target && pair.pred == null) pair.pred = pair.prev;
        if(pair.prev != null && pair.prev.data == target) pair.succ = node;
        pair.prev = node;
        allSolution(node.right,level+1,target,pair);
    }

    public static void PredSucc(Node node,int data){
        Node curr = node;
        Node pred =null,succ = null;
        while(curr != null){

            if(curr.data == data){
                if(curr.left != null){
                    pred = curr.left;
                    while(pred.right != null ){
                        pred =pred.right;
                    }
                }
                if(curr.right != null){
                    pred = curr.right;
                    while(pred.left != null ){
                        pred =pred.left;
                    }
                }
                break;
            }else if(curr.data < data){
                pred = curr;
                curr = curr.right;
            }else{
                succ = curr;
                curr = curr.left;
            }
        }
    }

}