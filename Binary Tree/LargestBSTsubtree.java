/*Question
  1. You are given a partially written BinaryTree class.
2. You are required to find the root of largest sub-tree which is a BST. Also, find the number of nodes in that sub-tree.
3. Input is managed for you. 

Note -> Please refer the question video for clarity.
                               
                               
Input Format
Input is managed for you.
Output Format
@
Constraints
Time complexity must be O(n)
Space should not be more than required for recursion (call-stack)
Sample Input
23
50 25 12 n n 37 30 n n 51 n n 75 62 60 n n 70 n n 87 n n
Sample Output
25@5*/
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

    Stack<Pair> st = new Stack<>();
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
  public static class BSTpair {
        int min, max;
        boolean isTreeBST;
        int largestBSTsize; // size of the largest bst in tree
        Node largestBSTroot; // node of the largest bst in tree
    }
  public static BSTpair largestBST(Node node) {
        if (node == null) {
            BSTpair base = new BSTpair();
            base.min = Integer.MAX_VALUE;
            base.max = Integer.MIN_VALUE;
            base.isTreeBST = true;
            return base;
        }
        BSTpair lp = largestBST(node.left); //left pair
        BSTpair rp = largestBST(node.right); //right pair
        boolean nBST = node.data >= lp.max && node.data <= rp.min;
        BSTpair res = new BSTpair();
        if (!nBST || !lp.isTreeBST || !rp.isTreeBST) {
            //tree is not  BST.
            res.isTreeBST = false;
        }else{
            res.isTreeBST = true;
        }
        res.min = Math.min(node.data, Math.min(lp.min, rp.min));
        res.max = Math.max(node.data, Math.max(lp.max, rp.max));
        
        if(res.isTreeBST){
            res.largestBSTsize = lp.largestBSTsize + rp.largestBSTsize+1;
            res.largestBSTroot = node;
        }else{
            if(lp.largestBSTsize >= rp.largestBSTsize){
                res.largestBSTsize = lp.largestBSTsize;
                res.largestBSTroot = lp.largestBSTroot;
            }else{
                res.largestBSTsize = rp.largestBSTsize;
                res.largestBSTroot = rp.largestBSTroot;
            }
        }
        return res;
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
    
    // write your code here
    BSTpair res = largestBST(root);
    System.out.print(res.largestBSTroot.data + "@"+ res.largestBSTsize);
  }

}