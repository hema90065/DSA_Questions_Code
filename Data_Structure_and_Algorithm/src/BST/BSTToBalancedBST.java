package BST;
import java.util.*;
public class BSTToBalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void findInOrder(Node root, ArrayList<Integer> inOrder){
        if (root == null){
            return;
        }
        findInOrder(root.left, inOrder);
        inOrder.add(root.data);
        findInOrder(root.right, inOrder);
    }
    public static Node balancedBST(ArrayList<Integer> inOrder, int st, int end){
        if (st > end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(inOrder.get(mid));
        root.left = balancedBST(inOrder, st, mid-1);
        root.right = balancedBST(inOrder, mid+1, end);

        return root;
    }
    public static Node createBalancedBST(Node root){ // O(n)
        // inorder seq - O(n)
        ArrayList<Integer> inOrder = new ArrayList<>();
        findInOrder(root, inOrder);

        // sorted inorder - Balanced BST - O(n)
        root = balancedBST(inOrder, 0,inOrder.size()-1);
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
    public static void main(String args[]){
        /*

                              8
                             / \
                            6   10
                           /      \
                          5        11
                         /           \
                        3             12

         */

        Node root = new Node(8);
        root.left = new Node(6);
        root.right = new Node(10);

        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        /*

               8
              / \
            5    11
           / \   /  \
          3   6  10  12

         */
        root = createBalancedBST(root);
        inOrder(root);
    }
}
