/*
  In this code we need to update tree values such as height,size,total, minimum
  etc. without returning the items from a function

  This approach is known as "TRAVEL AND CHANGE"
 */
import java.util.*;
import java.io.*;

public class Main {
    private static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child: node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    // height
    static int height;
    // size 
    static int size;
    // maximum
    static int maximum;
    // minimum
    static int minimum;
    // total
    static int total;
    
    public static void multisolver(Node node, int depth) {
        //pre area 
        size++;
        height = Math.max(height, depth);
        maximum = Math.max(maximum, node.data);
        minimum = Math.max(minimum, node.data);
        total += node.data;
        for (Node child: node.children) {
            multisolver(child, depth + 1);
        }
    }


    public static void main(String[] args) throws Exception {

        // write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // boolean sym = IsSymmetric(root);
        height = 0;
        size = 0;
        maximum = Integer.MIN_VALUE;
        minimum = Integer.MAX_VALUE;
        total = 0;
        multisolver(root, 0);
        
        System.out.println("Height :" + height);
        System.out.println("Size :" + size);
        System.out.println("maximum :" + maximum);
        System.out.println("minimum :" + minimum);
        System.out.println("totol :" + total);
    }
}