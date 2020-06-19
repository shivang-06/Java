import java.util.*;

public class Main {

    public static void main(String[] args) {

        // write your code here.
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",135);
        hm.put("china",150);
        hm.put("Pakistan",115);
        hm.put("Sri Lanka",90);
        hm.put("Utopia",50);
        
        System.out.println(hm.get("India"));
        hm.put("India",140);
        
        System.out.println(hm.containsKey("India"));
        hm.put("nepal",10);
        hm.put("Nepal",12);
        for(String key : hm.keySet()){
            System.out.println(key + " -> "+hm.get(key));
        }
        
        System.out.println(hm.values());
    }
}