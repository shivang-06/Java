class Bfs-LevelOrder{
    public static void main(String[] args) {
        solve();
    }
    public static void solve(){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = constructTree(arr);
    }
    public static Node constructTree(int[] arr){
        if(idx==arr.length || arr[idx]==-1){
            idx++;
            return null;
        }

        Node node=new Node(arr[idx++]);

        node.left = constructTree(arr);
        node.right = constructTree(arr);

        return node;
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
    public static int width(Node node,int level,int[] minMax){
        if(node == null) return 0;
        minMax[0] = Math.min(minMax[0],level);
        minMax[1] = Math.max(minMax[1],level);
        width(node.left,level-1,minMax);
        width(node.right,level+1,minMax);
        return minMax[1] - minMax[0];
    }
    
    public static class vPair{ // vertical pair
        Node node = null;
        int level = 0;
        public vPair(){
            this.node = node;
            this.level = level;
        }
    }
    public static void VerticalOrder(Node node){
        int[] minMax = new int[2];
        width(node,0,minMax);

    }
}