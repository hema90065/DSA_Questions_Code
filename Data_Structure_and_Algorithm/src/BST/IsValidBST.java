package BST;

import java.util.ArrayList;

public class IsValidBST {
    static  class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insertNode(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insertNode(root.left, val);
        }
        if(root.data < val){
            root.right = insertNode(root.right, val);
        }

        return root;
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }

        if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String args[]){
        int values1[] = {5, 1, 4, 3, 2, 7};
        int values2[] = {1, 2, 3, 6, 7, 8, 9, 10, 4, 5,};
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
       Node root = null;


        for (int i=0; i< values.length; i++){
            root = insertNode(root, values[i]);
        }

        inOrder(root);
        System.out.println();

        if(isValidBST(root, null, null)){
            System.out.println("Valid");
        } else {
            System.out.println("Not valid");
        }
    }
}
