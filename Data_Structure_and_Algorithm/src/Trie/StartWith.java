package Trie;

public class StartWith {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        Node(){
            for (int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){ // O(L)
        Node curr = root;
        for (int level = 0; level<word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null ){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static boolean search(String key){ // O(L)
        Node curr = root;
        for (int level = 0; level<key.length(); level++){
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null ){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
    public static boolean startWith(String prefix){
        Node curr = root;
        for (int level = 0; level<prefix.length(); level++){
            int idx = prefix.charAt(level) - 'a';
            if (curr.children[idx] == null ){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    public static void main(String args[]){
        String words[] = {"the", "a", "there", "their", "any", "thee"};

        for (int i=0; i< words.length; i++){
            insert(words[i]);
        }

        String key = "there";
        //System.out.println(search(key));

        System.out.println(startWith("the"));
        System.out.println(startWith("app"));
    }
}
