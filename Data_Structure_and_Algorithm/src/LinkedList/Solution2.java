package LinkedList;

public class Solution2 {
    public static class Node{
        int data;
        Node next;
        public Node( int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public Node tail;
    public static int size;

    public void print(){
        Node temp = head;
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void DeleteNNodesAfterMNodes( int M, int N, Node head){

        Node curr = head, t;
        int count;while (curr!=null){
            for (count = 1; count < M && curr != null; count++)
                curr = curr.next;

            if (curr == null)
                return;
            t = curr.next;
            for (count = 1; count <= N && t != null; count++){
                Node temp = t;
                t = t.next;
            }
            curr.next = t;
            curr = t;
        }
    }

    public void swappingNodes(Node head, int X, int Y){
        Node temp = head;
        Node x,y;
        while(temp != null){
            if(temp.data == X){
                x = temp;
            }
        }

        while(temp != null){
            if(temp.data == Y){
                y = temp;
            }
        }
    }
    public static void main(String args[]){
        // Sample Input 1: M=2 N=2    LL: 1->2->3->4->5->6->7->8
        // Sample Output 1: 1->2->5->6

        Solution2 ll = new Solution2();
        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        ll.print();
        System.out.println(size);
        ll.DeleteNNodesAfterMNodes(2,2,head);
        ll.print();


    }
}
