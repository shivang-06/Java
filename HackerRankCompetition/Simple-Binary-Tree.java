/* you will be given input of tree.

complete the following task : 1. contruct the tree. 2. display the tree (format : leftChildData -> nodeData <- rightChildData). 3. print max element. 4. print min element. 5. print height of the tree. 6. print sum of all elements. 7. print size of tree.

Example : Input: 27 10 20 30 50 60 null null null null 40 null null 70 80 71 null null null 90 null -100 1100 null null 245 null null

Output: 20 -> 10 <- 70 30 -> 20 <- 40 50 -> 30 <- . 60 -> 50 <- . . -> 60 <- . . -> 40 <- . 80 -> 70 <- 90 71 -> 80 <- . . -> 71 <- . . -> 90 <- -100 1100 -> -100 <- 245 . -> 1100 <- . . -> 245 <- .

max element : 1100

min element : -100

height of tree :4

sum of elements :1766

size of tree :13 `

Input Format

Input is handled for you.
Constraints

0 <= N <= 100
Output Format

Output is handled for you.
Sample Input 0

27
10 20 30 50 60 null null null null 40 null null 70 80 71 null null null 90 null -100 1100 null null 245 null null
Sample Output 0

20 -> 10 <- 70
30 -> 20 <- 40
50 -> 30 <- .
60 -> 50 <- .
. -> 60 <- .
. -> 40 <- .
80 -> 70 <- 90
71 -> 80 <- .
. -> 71 <- .
. -> 90 <- -100
1100 -> -100 <- 245
. -> 1100 <- .
. -> 245 <- .

 max element : 1100

 min element : -100

 height of tree :4

 sum of elements :1766

 size of tree :13*/
 import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
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
  public static void display(Node node){
      if(node == null){
          return;
      }
      String str = "";
      if(node.left == null){
          str +=".";
      }else{
          str +=node.left.data;
      }
      str += " -> " + node.data+" <- ";
      if(node.right == null){
          str += ".";
      }else{
          str += node.right.data;
      }
      System.out.println(str);
      display(node.left);
      display(node.right);
  }  
    public static int height(Node node){
        if(node == null){
            return -1;
        }
        int lH = height(node.left);
        int rH = height(node.right);
        
        int tot = Math.max(lH,rH) + 1;
        
        return tot;
    }
    public static int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        
        int lmax = max(node.left);
        int rmax = max(node.right);
        
        int totMax = Math.max(node.data, Math.max(lmax,rmax));
        return totMax;
    }
    public static int min(Node node){
        if(node == null){
            return Integer.MAX_VALUE;
        }
        
        int lmin = min(node.left);
        int rmin = min(node.right);
        
        int totMin = Math.min(node.data,Math.min(lmin,rmin));
        return totMin;
    }
    public static int sum(Node node){
        if(node == null){
            return 0;
        }
        
        int lsum = sum(node.left);
        int rsum = sum(node.right);
        
        int totSum = node.data + lsum + rsum;
        return totSum;
    }
    public static int size(Node node){
        if(node == null){
            return 0;
        }
        int lsize = size(node.left);
        int rsize = size(node.right);
        
        int totSize = lsize + rsize + 1;
        return totSize;
    }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("null") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    display(root);
      System.out.println();
      System.out.println(" max element : "+max(root));
      System.out.println();
      System.out.println(" min element : "+min(root));
      System.out.println();
      System.out.println(" height of tree :"+height(root));
      System.out.println();
      System.out.println(" sum of elements :"+sum(root));
      System.out.println();
      System.out.println(" size of tree :"+size(root));
      
      

  }
}