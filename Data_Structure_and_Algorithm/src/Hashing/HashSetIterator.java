package Hashing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSetIterator {
    public static void main(String args[]){
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Kolkata");
        cities.add("Noida");
        cities.add("Bangaluru");
        System.out.println(cities);

//        Iterator it = cities.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

//        for (String city: cities) {
//            System.out.println(city);
//        }

        LinkedHashSet<String> lhm = new LinkedHashSet<>();
        lhm.add("Delhi");
        lhm.add("Mumbai");
        lhm.add("Kolkata");
        lhm.add("Noida");
        lhm.add("Bangaluru");
        System.out.println(lhm);

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Kolkata");
        ts.add("Noida");
        ts.add("Bangaluru");
        System.out.println(ts);

    }
}
