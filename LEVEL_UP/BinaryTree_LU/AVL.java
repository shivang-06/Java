public class AVL{
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        int height = 0; //height factor
        int bal = 0; // balancing factor

        Node(int data){
            this.data = data;
        }
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

    public static Node leftRotation(Node A){
        Node B = A.left;
        Node Bleft = B.left;

        b.left = A;
        A.right = Bleft;

        updateBalHeight(A);
        updateBalHeight(B);
        return B;
    }
    public static Node rightRotation(Node A){
        Node B = A.left;
        Node Bright = B.right;

        b.right = A;
        A.left = Bright;

        updateBalHeight(A);
        updateBalHeight(B);
        return B;
    }

    public static Node getRotation(Node node){
        updateBalHeight(node);
        if(node.bal == 2){
            if(node.left.bal == 1){ //LL
                return rightRotation(node);
            }else{  //LR
                
            }

        }else if(node.bal == -2{
            if(node.right.right == -1){ //RR
                return leftRotation(node);
            }else{ //RL

            }
        }
    }
    public static void updateBalHeight(Node node){
        int lh=-1;
        int rh=-1;

        lh = node.left.height;
        rh = node.right.height;
        node.bal = lh - rh;
        node.height = Math.max(lh,rh) + 1;
    }
}