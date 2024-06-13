package BST;

import java.util.ArrayList;
import java.util.HashMap;

public class FindTheClosestElementInBST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static int min_diff = Integer.MAX_VALUE, min_diff_key;
    public static void closestElementInBST(Node root, int k) {
        if (root == null) {
            return;
        }

        if(root.data == k){
            min_diff_key = k;
        }

        if(min_diff > Math.abs(root.data -k)){
            min_diff = Math.abs(root.data -k);
            min_diff_key = root.data;
        }

        closestElementInBST(root.left, k);
        closestElementInBST(root.right, k);
    }
    public static void main(String args[]){
        /*
                    8
                  /   \
                5      11
               /  \      \
              3    6      20
       */

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);


        int k = 15;
        closestElementInBST(root, k);

        System.out.println(min_diff_key);
        System.out.println(min_diff);
    }
}

