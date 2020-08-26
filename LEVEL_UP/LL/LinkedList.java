public class LinkedList{
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

    private void addLastNode(int data){
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
    public int removeFirst() throw Exception{
        if(this.size == 0){
            throw new Exception("EmptyList");
        }
        Node rnode = removeFirstNode();
        return new rnode.data;
        
    }
    private Node removeFirstNode(){

    }
    public int removeFirst() throw Exception{
        if(this.size == 0){
            throw new Exception("EmptyList");
        }
        
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
}