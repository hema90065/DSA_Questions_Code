package BinaryTrees;

public class InvertBinaryTree {
    static  class  Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node isInvert(Node root){
        if(root == null){
            return root;
        }
        Node leftSubTree = isInvert(root.left);
        Node rightsubTree = isInvert(root.right);

        root.left = rightsubTree;
        root.right = leftSubTree;

        return root;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String args[]) {

         /*
               1
              / \
             2   3
            / \ / \
           4  5 6  7

        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        preOrder(root);
        isInvert(root);
        preOrder(root);
    }
}
