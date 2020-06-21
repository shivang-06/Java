import java.util.*;

public class Main {

    public static void main(String[] args) {

        // write your code here.
        PriorityQueue < Integer > pq = new PriorityQueue < > (); // Min priority Queue
        PriorityQueue < Integer > pq2 = new PriorityQueue < > (Collections.reverseOrder()); // Max priority queue
        
        pq.add(10);
        pq.add(20);
        pq.add(400);
        pq.add(-20);
        pq.add(210);
        pq.add(20000);
        pq.add(70);
        pq.add(0);
        pq.add(-520);
        pq.add(-9920);
        pq.add(1120);
        pq.add(-2);
        //-------------------------------
        pq2.add(10);
        pq2.add(20);
        pq2.add(400);
        pq2.add(-20);
        pq2.add(210);
        pq2.add(20000);
        pq2.add(70);
        pq2.add(0);
        pq2.add(-520);
        pq2.add(-9920);
        pq2.add(1120);
        pq2.add(-2);
        
        System.out.println("Size ==>"+ pq.size());
        while (pq.size() != 0) {
            System.out.println(pq.remove());
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("Size ==>"+ pq2.size());
        while (pq2.size() != 0) {
            System.out.println(pq2.remove());
        }

    }
}