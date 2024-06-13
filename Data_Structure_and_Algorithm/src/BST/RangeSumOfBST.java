package BST;

public class RangeSumOfBST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static int sum = 0;
    public static void rangeSunOfBST(Node root, int L, int R){
        if (root == null){
            return;
        }

        if (root.data > L && root.data < R){
            sum += root.data;
        }

        rangeSunOfBST(root.left, L, R);
        rangeSunOfBST(root.right, L, R);

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

        int L = 5, R = 10;
        rangeSunOfBST(root, L, R);

        System.out.println("Range sum of BST = " + sum);
    }
}
