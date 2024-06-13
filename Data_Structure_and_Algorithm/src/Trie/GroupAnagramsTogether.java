package Trie;
import java.util.*;
import java.util.ArrayList;
public class GroupAnagramsTogether {
   static class TrieNode {
        List<String> data;
        TrieNode children[];
        boolean isEnd;
        TrieNode(){
            data = new ArrayList<>();
            children = new TrieNode[26];
            isEnd = false;
        }
    }
        public static TrieNode  root = new TrieNode(); ;
        static List<List<String>> ans;
        public static List<List<String>> groupAnagrams(String[] strs) {
            ans = new ArrayList<>();

            for(String word: strs){
                build(word);
            }
            dfs(root);
            return ans;
        }
        public static void build(String s){
            TrieNode temp = root;
            char[] word = s.toCharArray();
            Arrays.sort(word);
            for(char c: word){
                TrieNode child = temp.children[c-'a'];
                if(child == null) temp.children[c-'a'] = new TrieNode();
                temp = temp.children[c-'a'];
            }
            temp.isEnd = true;
            temp.data.add(s);
        }
        public static void dfs(TrieNode rt){
            if(rt.isEnd){
                ans.add(rt.data);
            }
            for(int i = 0; i < 26; i++){
                if(rt.children[i] != null) dfs(rt.children[i]);
            }
        }
    public static void main(String args[]){
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));
        //groupAnagrams(strs);

//        for(int i=0; i< strs.length; i++ ){
//            build(strs[i]);
//        }

    }

}
