package BST;

public class SortedArrayToBalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createBalancedBST(int arr[], int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st + end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBalancedBST(arr, st, mid-1);
        root.right = createBalancedBST(arr, mid+1, end);
        return root;
    }

    public static void main(String arg[]){
        int arr[] = {3, 5, 6, 8, 10, 11, 12};

         /*

               8
              / \
            5    11
           / \   /  \
          3   6  10  12

         */

        Node root = createBalancedBST(arr,0, arr.length-1);
        preOrder(root);
    }
}
