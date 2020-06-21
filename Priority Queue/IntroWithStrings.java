import java.util.*;

public class Main {

    public static void main(String[] args) {

        // write your code here.
        
        PriorityQueue < String > pq2 = new PriorityQueue < > (Collections.reverseOrder()); // Max priority queue
        
     
        pq2.add("abcdef");
        pq2.add("bcdefg");
        pq2.add("gfedcb");
        pq2.add("fedcba");
        pq2.add("cdefgh");
        pq2.add("z");
        pq2.add("aaaaaaaaaa");
        
        
        // System.out.println("-----------------------------------------------------------");
        System.out.println("Size ==>"+ pq2.size());
        while (pq2.size() != 0) {
            System.out.println(pq2.remove());
        }

    }
}