package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<k, v> {
        private class Node{
            k key;
            v value;
            public Node(k key, v value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; //n
        private int N;
        private LinkedList<Node> buckets[]; //N

        public HashMap(){
            N= 4;
            this.buckets = new LinkedList[4];
            for (int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(k key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }
        private int searchInLL(k key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for (int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        private void reHash(){
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[2*N];
            N = 2*N;
            for (int i=0; i< buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            // nodes -> add in bucket
            for (int i=0; i<oldBuck.length; i++){
                LinkedList<Node> ll = oldBuck[i];
                for (int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }
        public void put(k key, v value){ // o(lembda) -> o(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lembda = (double) n/N;
            if (lembda > 2.0){
                reHash();
            }
        }

        public boolean containsKey(k key){ // o(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1){
                return true;
            } else {
              return false;
            }
        }

        public v remove(k key){ // o(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }
        public v get(k key){ // O(n)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }
        public ArrayList<k> keySet(){
            ArrayList<k> key = new ArrayList<>();
            for (int i=0; i< buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll){
                    key.add(node.key);
                }
            }
            return key;
        }
        public boolean isEmpty(){
            return  n == 0;
        }
    }
    public static void main(String args[]){
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("china", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        ArrayList<String> keys = hm.keySet();
        for (String key : keys){
            System.out.println(key);
        }
    }
}
