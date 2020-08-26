public class linkedlist{
    private class Node{
        int data = 0;
        Node next = null;

        Node(int data){
            this.data = data;
        }
    }

    private Node head = null; 
    private Node tail = null;
    private int size = 0;
    
    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
    // ================= add ============================
    private void addFirtstNode(Node Node){
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }
    public void addFirst(int data){
        Node node = new Node(data);
        addFirtstNode(node);
    }

    private void addLastNode(Node node){
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;

    }
    public void addLast(int data){
        Node node = new Node(data);
        addLastNode(node);
    }

    private void addNodeAt(int idx,Node node){
        if(idx == 0) addFirtstNode(node);
        else if(idx == this.size) addLastNode(node);
        else{
            Node prev = getNodeAt(idx-1);
            Node forw = prev.next;

            prev.next = node;
            node.next = forw;
            this.size++;
        }
    }
    public void addAt(ind idx){
        if(idx == 0) addFirst();
        else if(idx == this.size-1) addLast();
        else addNodeAt();
    }

    //====================== Remove ================
    private Node removeFirstNode(){
        Node rn = this.head;
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }else{
            this.head = this.head.next;
        }
        rn.next = null; // so that removed node disconnects from the LL.
        this.size--;
        return rn;
    }
    public int removeFirst() throws Exception{
        if(this.size == 0){
            throw new Exception("EmptyList");
        }
        Node rnode = removeFirstNode();
        return new rnode.data;
        
    }
    private Node removeLastNode(){
        Node rn = this.tail;
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }else{
            Node secondLastNode = getNodeAt(this.size-2);
            secondLastNode.next = null;
            this.tail = secondLastNode;
        }
        rn.next = null;
        this.size--;
        return rn;
    }
    public int removeLast() throws Exception{
        if(this.size == 0){
            throw new Exception("EmptyList");
        }
        Node rn = removeLastNode();
        return rn.data;
    }
    private Node removeNodeAt(int idx){
        if(idx == 0){
            return removeFirstNode();
        }else if(idx == this.size-1){
            return removeLastNode();
        }else{
            Node prev = getNodeAt(idx-1);
            Node rnode = prev.next;
            prev.next = prev.next.next;
            rnode.next = null;
            this.size--;
            return rnode;
        }
    }
    public int removeAt(int idx) throws Exception{
        if(idx < 0 || idx>= this.size){
            throw new Exception("NullPointer");
        }
        node rnode = removeNodeAt(idx);
        return rnode.data;

    }
    // =====================  Get ========================
    public int getFirst() throws Exception{
        if(this.size == 0){
            throw new Exception "EmptyList";
        }
        return this.head.data;
    }
    public int getLast() throws Exception{
        if(this.size == 0){
            throw new Exception "EmptyList";
        }
        return this.tail.data;
    }
    private Node getNodeAt(int idx){
        Node node = this.head;
        while(idx-->0){
            node = node.next;
        }
        return node;
    }
    public int getAt(int idx){
        if(idx == 0) return getFirst();
        else if(idx == this.size-1) return getLast();
        else{
            Node rnode = getNodeAt(idx);
            return rnode.data;
        }
    }
}