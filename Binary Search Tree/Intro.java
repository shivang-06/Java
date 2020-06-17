import java.io.*;
import java.util.*;

public class Main {
    
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }


    public static Node construct(int []input, int lo, int hi){
        if(lo>hi){
            //invalid index reached
            return null;
        }
        int mid = (lo+hi)/2;
        int data = input[mid];
        Node lc = construct(input,lo,mid-1); //left child
        Node rc = construct(input,mid+1,hi); // right child
        Node node = new Node(data,lc,rc);
        return node;
    }
    public static void main(String[] args) throws Exception {
        int []input = {12,25,37,50,62,75,87};
        Node root = construct(input,0,input.length-1);
        display(root);
    }

}