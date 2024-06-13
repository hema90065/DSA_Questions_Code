package BST;

import java.util.ArrayList;

public class BinarySearchTree {
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

    public static boolean searchKey(Node root, int key){ // O(H)
        if (root == null){
            return false;
        }

        if (root.data == key){
            return true;
        }

        if(root.data > key){
            return searchKey(root.left, key);
        } else {
            return  searchKey(root.right, key);
        }
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static Node findInOrderSuccessor(Node root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // case1 - leaf node
            if(root.left == null && root.right == null){
                return  null;
            }

            // case2 - single child
            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // case 3 - both child
                Node IS = findInOrderSuccessor(root.right);
                root.data = IS.data;
                //System.out.println(IS.data);
                delete(root.right, IS.data);
            }
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2){
        if (root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);

        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for (int i=0; i< path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    public static void printRoot2leaf(Node root, ArrayList<Integer> path){
        if (root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2leaf(root.left, path);
        printRoot2leaf(root.right, path);
        path.remove(path.size()-1);
    }
    public static void main(String args[]){
        //int values[] = {5, 1, 4, 3, 2, 7};
        //int values[] = {1, 2, 3, 6, 7, 8, 9, 10, 4, 5,};
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        int key = 9;

        for (int i=0; i< values.length; i++){
            root = insertNode(root, values[i]);
        }

        inOrder(root);
        System.out.println();

//        if(searchKey(root, key)){
//            System.out.println("Found");
//        } else {
//            System.out.println("Not Found");
//        }
//         root = delete(root, 5);
//         inOrder(root);

        //       printInRange(root,5, 11);

        ArrayList<Integer> path = new ArrayList<>();
        printRoot2leaf(root, path);

    }
}
