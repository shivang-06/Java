/*Question
 1. You are given a partially written BinaryTree class.
2. You are required to complete the body of size, sum, max and height function. The functions are expected to
2.1. size - return the number of nodes in BinaryTree
2.2. sum - return the sum of nodes in BinaryTree
2.3. max - return the highest node in BinaryTree
2.4. height - return the height of tree in terms of edges
3. Input and Output is managed for you. 
                               
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
None
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
Sample Output
9
448
87
3*/
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

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack < Pair > st = new Stack < > ();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
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

    public static int size(Node node) {
        // write your code here
        if (node == null) {
            //base case
            return 0;
        }

        int lSize = size(node.left); //Size of left child
        int rSize = size(node.right); // size of right child

        int totSize = lSize + rSize + 1; //total size of binary tree.
        return totSize;
    }

    public static int sum(Node node) {
        // write your code here
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lSum = sum(node.left);
        int rSum = sum(node.right);
        
        int totSum = lSum + rSum + node.data;
        return totSum;
    }

    public static int max(Node node) {
        
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lMax = max(node.left);
        int rMax = max(node.right);
        
        int totMax = Math.max(Math.max(lMax,rMax),node.data);
        
        return totMax;
    }

    public static int height(Node node) {
        
        if(node == null){
            return -1;
        }
        int lht = height(node.left);
        int rht = height(node.right);
        
        int totHt = Math.max(lht,rht) + 1;
        return totHt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);
    }

}