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
    public static boolean NodeToRootPath(Node node,int data,ArrayList<Node> path){
        if(node.data == data){
            path.add(node);
            return true;
        }

        boolean res = false;
        for(Node child: node.childs){
            res = res || NodeToRootPath(child,data,path);
        }
        if(res) path.add(node);
        return res;
    }
    public static void lca(Node node,int a,int b){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        NodeToRootPath(node,a,path1);
        NodeToRootPath(node,b,path2);
        int i = path1.size()-1;
        int j = path2.size()-1;
        Node lca = null;
        while(i >=0 && j>=0){
            if(path1.get(i)!=path2.get(j)){
                break;
            }
            lca = path1.get(i);
            i--;
            j--;
        }
        System.out.println(lca.data);
    }
    public static void zigZag(Node node){
        Stack<Node> st1 = new Stack<>(); //for parent
        st1.add(node);
        Stack<Node> st2 = new Stack<>(); // for children
        boolean flag = true;
        while(st1.size()!=0){
            int size = st1.size();
            while(size-->0){
                Node rem = st1.pop(); //removed node    
                System.out.print(rem.data + " ");
                if(flag){
                    for(Node child : node.childs){
                        st2.push(child);
                    }
                }else{
                    for(int i = node.childs.size()-1;i>=0;i--){
                        Node child = node.childs.get(i);
                        st2.push(child);
                    }
                }
            }
            flag = !flag;
            Stack<Node> temp = st1;
            st1 = st2;
            st2 = temp;
            System.out.println();
        }
        
    }
    public static void solve(){
        int[] arr={10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 110, -1, -1, 90, -1, -1, 40, 120, 140, -1, 150, -1, -1, -1,-1};
        Node root = constructGTree(arr);
        // display(root);
        // zigZag(root);
        lca(root,40,90);
    }
}