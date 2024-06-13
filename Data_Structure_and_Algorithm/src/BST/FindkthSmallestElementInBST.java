package BST;

import java.util.ArrayList;

public class FindkthSmallestElementInBST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void findInorder(Node root, ArrayList<Integer> inOrder){
        if(root == null){
            return;
        }
        findInorder(root.left, inOrder);
        inOrder.add(root.data);
        findInorder(root.right, inOrder);
    }
    public static void findKthSmallestElementInBST(Node root, int k){
        //inorder seq
        ArrayList<Integer> inOrder = new ArrayList<>();
        findInorder(root, inOrder);

        System.out.print(inOrder.get(k));
        System.out.println();
    }
    public static void main(String args[]) {
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

        findKthSmallestElementInBST(root, 5);
    }
}
