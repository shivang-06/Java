public class loo1{
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
}