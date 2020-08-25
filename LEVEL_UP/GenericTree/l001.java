import java.util.*;
public class l001{

    public static void main(String[] args) {
        solve();
    }
    public static class Node{
        int data = 0;
        ArrayList<Node> childs = new ArrayList<>();
        Node(int data){
            this.data = data;
        }
    }
    public static Node constructGTree(int[] arr){
        Stack<Node> st = new Stack<>();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=-1){
                st.push(new Node(arr[i]));
            }else{
                Node node = st.pop();
                st.peek().childs.add(node);
            }
        }
        return st.peek();
    }
    public static void display(Node node){
        StringBuilder sb = new StringBuilder();
        sb.append(node.data + " -> ");

        for(Node child:node.childs){
            sb.append(child.data+", ");
        }
        System.out.println(sb);
        for(Node child:node.childs){
            display(child);
        }
    }
    public static int height(Node node){
        int h = -1;
        for(Node child:node.childs){
            h = Math.max(h,height(child));
        }
        return h+1;
    }
    public static int size(Node node){
        int s=0;
        for(Node child:node.childs) s+=size(child);
        return s+1;
    }
    public static int maximum(Node node){
        int max = node.data;
        for(Node child:node.childs){
            max = Math.max(max,maximum(child));
        }
        return max;
    }
    public static boolean find(Node node,int data){
        if(node.data == data) return true;
        for(Node child:node.childs){
            if(find(child,data))return true;
        }
        return false;
    }
    public static void solve(){
        int[] arr={10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 110, -1, -1, 90, -1, -1, 40, 120, 140, -1, 150, -1, -1, -1,-1};
        Node root = constructGTree(arr);
        display(root);

    }
}