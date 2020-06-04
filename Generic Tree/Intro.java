import java.util.*;

public class Main {

    public static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }

    public static Node construct(int[] input) {
        Stack<Node> st = new Stack<>();
        Node root = new Node();
        root.data = input[0];
        st.push(root);
        
        for(int i=1 ; i<input.length;i++){
            int d = input[i];
            if(d==-1){
                st.pop();
            }else{
                Node node = new Node();
                node.data =d;
                //find its parent
                Node parent = st.peek();
                
                //make node , child ofn parent
                parent.children.add(node);
                st.push(node);
            }
        }
        return root;
    }
    
    public static void display(Node node){
        //self printing
        System.out.print(node.data+" -> ");
        for(int i=0;i<node.children.size();i++){
            Node child = node.children.get(i);
            System.out.print(child.data + ", ");
        }
        System.out.println(".");
        
        //child printing
        for(int i=0;i<node.children.size();i++ ){
            Node child =  node.children.get(i);
            display(child);
        }
    }

    public static void main(String[] args) {

        // write your code here.
        int[] input = {10,20,50,-1,60,-1,-1,30,70,-1,-1,40,100,-1,-1,-1};
        
        Node root = construct(input);
        display(root);
    }
}