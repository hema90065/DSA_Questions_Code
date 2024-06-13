package BinaryTrees;

public class DeleteSameLeaves {
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
    public static Node deleteLeaves(Node root, int x){
        if(root == null){
            return root;
        }
        root.left = deleteLeaves(root.left, x);
        root.right = deleteLeaves(root.right, x);

        if(root.data == x && root.left == null && root.right == null){
            return  null;
        }

        return root;
    }
    public static void preOrder(Node root){
        if (root == null){
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
           4  3 6  3

        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(3);

        preOrder(root);
        System.out.println();
        deleteLeaves(root, 3);
        System.out.println();
        preOrder(root);

    }
}
