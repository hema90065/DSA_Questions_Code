package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class FindMinimumDepthOfABinaryTree {
    //Find Minimum Depth of a Binary Tree
    static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    static class qItem{
        Node node;
        int depth;
        public qItem(Node n, int d){
            this.node =n;
            this.depth = d;
        }
    }
    public static int findDepth(Node root){
        Queue<qItem> q = new LinkedList<>();
        q.add(new qItem(root,1));

        while (!q.isEmpty()){
            qItem qi = q.remove();
            Node node = qi.node;
            int depth = qi.depth;

            if(node.left == null && node.right == null){
                return depth;
            }

            if(node.left != null){
                node = node.left;
                q.add(new qItem(node, depth+1));
            }

            if(node.right != null){
                node = node.right;
                q.add(new qItem(node, depth+1));
            }
        }
        return -1;
    }

    public static void main(String args[]){
        /*
                         1
                       /   \
                      8     2
                     / \   /
                    6   5  9
         */
        Node root = new Node(1);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.left.right = new Node(5);
        root.right.left = new Node(9);

        System.out.print(findDepth(root));
    }

}
