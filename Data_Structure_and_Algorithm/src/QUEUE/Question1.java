package QUEUE;

public class Question1 {

    // Implementation of Queue using LinkedList
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data= data;
            this.next = null;
        }
    }

    static class QueueLL{
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        //add
        public static void add(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
            }
            tail.next = newNode;
            tail = newNode;
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.print("LL is empty");
                return -1;
            }
            int front = head.data;
            if(head == tail){
                head = tail = null;
            } else{
                head = head.next;
            }
            return front;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.print("LL is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String args[]){
        QueueLL q = new QueueLL();
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(4);
        q.remove();
        q.add(5);

        while (!q.isEmpty()){
            System.out.print(q.peek() + " ");
            q.remove();
        }

    }
}
