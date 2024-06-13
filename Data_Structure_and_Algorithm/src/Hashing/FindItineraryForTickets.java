package Hashing;

import java.util.HashMap;

public class FindItineraryForTickets {
    public static String getStart(HashMap<String, String> map){
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : map.keySet()){
            revMap.put(map.get(key), key);
        }

        for (String key : map.keySet()){
            if (!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String args[]){ // o(n)
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai","Bangaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()){
            System.out.print("->"+tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }
}
