package Hashing;
import java.util.*;
public class HashMapOperations {
    public static void main(String args[]){
        //Create
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert - O(n)
        hm.put("India", 100);
        hm.put("US", 50);
        hm.put("China", 150);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        System.out.println(hm);

        //Get - O(n)
//        int population = hm.get("India");
//        System.out.println(population);
//
//        System.out.println(hm.get("Indonesia"));
//
//        //ContainsKey - O(n)
//        System.out.println(hm.containsKey("India")); //true
//        System.out.println(hm.containsKey("Indonesia")); //false

        //Remove
//        System.out.println(hm.remove("China"));
//        System.out.println(hm);
//        System.out.println(hm.remove("Indonesia"));
//        System.out.println(hm);

//        //size
//        System.out.println(hm.size());
//        hm.clear();
//        // Is Empty
//        System.out.println(hm.isEmpty());

        //Iterate
        System.out.println(hm.entrySet());

        Set<String> key = hm.keySet();
        System.out.println(key);

        for (String k:key) {
            System.out.println("Key = "+k+", value = "+hm.get(k));
        }
    }
}
