package BinaryTrees;

public class MinimumDistanceBetween2Nodes {
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
    public static Node lca(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        if(leftLca == null){
            return rightLca;
        }

        if(rightLca == null){
            return leftLca;
        }

        return root;
    }

    public static int getpath(Node root, int n){
        if(root == null){
            return  -1;
        }
        if (root.data == n){
            return  0;
        }
        int leftPath = getpath(root.left, n);
        int rightPath = getpath(root.right, n);

        if(leftPath == -1 && rightPath == -1){
            return  -1;
        } else if (leftPath == -1) {
            return rightPath+1;
        } else {
            return leftPath+1;
        }
    }

    public static int minDist(Node root, int n1, int n2){
        Node lca = lca(root, n1, n2);
        int path1 = getpath(lca, n1);
        int path2 = getpath(lca, n2);

        return path1 + path2;
    }

    public static int kAncestor(Node root, int n, int k){
        if (root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1){
            return  -1;
        }

        int max = Math.max(leftDist, rightDist);
        if (max+1 == k){
            System.out.println(root.data);
        }

        return max+1;
    }
    public static void main(String args[]){

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

        int n1 = 4, n2 = 7;

        //System.out.println(lca(root, n1, n2).data);
        //System.out.print("Minimum dintance between 2 nodes = " + minDist(root, n1, n2));

        kAncestor(root, 4, 2);
    }
}
