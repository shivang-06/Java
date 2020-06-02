/*Question
 1. You are required to complete the code of our LLToQueueAdapter class. 
2. As data members, you've a linkedlist available in the class.
2. Here is the list of functions that you are supposed to complete
2.1. add -> Should accept new data in FIFO manner
2.2. remove -> Should remove and return data in FIFO manner. If not available, print "Queue underflow" and return -1.
2.3. peek -> Should return data in FIFO manner. If not available, print "Queue underflow" and return -1.
2.4. size -> Should return the number of elements available in the queue
3. Input and Output is managed for you.

Note -> The intention is to use linked list functions to achieve the purpose of a queue. All the functions should work in constant time.

                               
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
None
Sample Input
add 10
add 20
add 30
add 40
add 50
remove
remove
add 60
add 70
peek
remove
peek
remove
peek
remove
peek
remove
peek
remove
peek
remove
quit
Sample Output
10
20
30
30
40
40
50
50
60
60
70
70
Queue underflow
Queue underflow*/
import java.io.*;
import java.util.*;

public class Main {

  public static class LLToQueueAdapter {
    LinkedList<Integer> list;

    public LLToQueueAdapter() {
      list = new LinkedList<>();
    }

    int size() {
      // write your code here
      return list.size();
    }

    void add(int val) {
      // write your code here
      list.addLast(val);
    }

    int remove() {
      // write your code here
      if( list.size() == 0 ){
          System.out.println("Queue underflow");
          return -1;
      }
      return list.removeFirst(); 
      }

    int peek() {
      // write your code here
      if( list.size() == 0 ){
          System.out.println("Queue underflow");
          return -1;
      }
      return list.getFirst();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LLToQueueAdapter qu = new LLToQueueAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}