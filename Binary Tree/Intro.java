import java.util.*;

public class Main {

    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class pair {
        Node node;
        int state;
        pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static Node construct(Integer[] ip) {
        Node root = new Node(ip[0]);
        Stack < pair > st = new Stack < > ();
        st.push(new pair(root, 1));
        int idx = 1;

        while (st.size() > 0) {
            pair top = st.peek();

            if (top.state == 1) {
                //left child to be processed
                Integer val = ip[idx];
                if (val != null) {
                    Node node = new Node(val);
                    top.node.left = node;
                    st.push(new pair(node, 1));
                } else if (val == null) {
                    top.node.left = null;
                }
                top.state++;
                idx++;
            } else if (top.state == 2) {
                //right child to be processed
                Integer val = ip[idx];
                if (val != null) {
                    Node node = new Node(val);
                    top.node.right = node;
                    st.push(new pair(node, 1));
                } else if (val == null) {
                    top.node.right = null;
                }
                top.state++;
                idx++;
            } else if (top.state == 3) {
                //both child have been processed
                st.pop();
            }
        }

        return root;
    }
    public static void display(Node node){
        if(node == null){
            //invalid spot
            return;
        }
        String str ="";
        if(node.left!=null){
            str +=node.left.data;
        }else{
            str +=".";
        }
        str += "<- "+node.data+" ->";
        if(node.right!=null){
            str += node.right.data;
        }else{
            str += ".";
        }
        System.out.println(str);
        display(node.left);
        display(node.right);
        
    }
    public static void main(String[] args) {

        // write your code here.
        Integer[] input = {10,20,40,null,null,50,60,null,null,null,30,null,70,80,null,null,90,null,null};
        Node root = construct(input);
        display(root);
    }
}