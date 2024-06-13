package Stack;

public class StackLL {
    public static class  Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class  Stack{
        static Node head = null;

        public static boolean isEmpty(){
            return  head==null;
        }

        //push
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        //peek
        public static int peek(){
            int top = head.data;
            return top;
        }
    }
    public static void main(String args[]){
        Stack llS = new Stack();
        llS.push(1);
        llS.push(2);
        llS.push(3);

        while(!llS.isEmpty()){
            System.out.println(llS.pop());
        }
    }
}
