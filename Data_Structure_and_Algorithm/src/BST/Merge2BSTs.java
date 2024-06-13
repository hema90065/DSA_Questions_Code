package BST;

import java.util.ArrayList;

public class Merge2BSTs {
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
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void getInOrder(Node root, ArrayList<Integer> arr){
        if (root == null){
            return;
        }
        getInOrder(root.left, arr);
        arr.add(root.data);
        getInOrder(root.right, arr);
    }
    public static Node createBalancedBST(ArrayList<Integer> arr, int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBalancedBST(arr,st, mid-1);
        root.right = createBalancedBST(arr, mid+1, end);
        return root;
    }
    public static Node mergeBST(Node root1, Node root2){
        //inorder seq - 1st BST
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOrder(root1, arr1);

        //inorder seq - 2nd BST
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root2, arr2);

        //merge
        ArrayList<Integer> finalArr = new ArrayList<>();
        int i=0, j=0;
        while (i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        // create BST
       return createBalancedBST(finalArr,0, finalArr.size()-1);
    }
    public static void main(String args[]){
        /*
             2
            / \
           1   4
           BST1
       */

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

         /*
             9
            / \
           3   12
           BST2
       */

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        /*
         O(n+m)
                     3
                   /   \
                  1     9
                   \   /   \
                    2 4     12
               Final Ans - BST
         */

        Node root = mergeBST(root1, root2);
        preOrder(root);

    }
}
