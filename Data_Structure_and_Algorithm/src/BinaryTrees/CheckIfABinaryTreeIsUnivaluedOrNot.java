package BinaryTrees;

public class CheckIfABinaryTreeIsUnivaluedOrNot {
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

    public static boolean isUniValueTree(Node root){
        if(root == null){
            return true;
        }

        if(root.left != null && root.data != root.left.data){
            return false;
        }
        if(root.right != null && root.data != root.right.data){
            return false;
        }

        return isUniValueTree(root.left) && isUniValueTree(root.right);
    }
    public static void main(String args[]) {

         /*
               1
              / \
             2   3
            / \ / \
           4  5 6  7

        */

        Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(2);
        root.right.left = new Node(2);
        root.right.right = new Node(2);

        //System.out.println(isUniValueTree(root));
        if(isUniValueTree(root)){
            System.out.print("YES");
        } else {
            System.out.print("No");
        }
        System.out.println();
    }
}
