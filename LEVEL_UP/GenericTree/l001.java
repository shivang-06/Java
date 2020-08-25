public class loo1{

    public static void main(String[] args) {
        solve();
    }
    public static clss Node{
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
    public void display(Node root){
        if(root == -1){
            system.out.print(".");
        }
        System.out.print(root.data +" -> ");
        for(Node a:root.childs){
            display(a);
        }
    }

    public static void solve(){
        int[] arr={10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 110, -1, -1, 90, -1, -1, 40, 120, 140, -1, 150, -1, -1, -1,-1};
        Node root = constructGTree(arr);
        display(root);

    }
}