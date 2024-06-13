package QUEUE;
import java.util.*;

public class Deque {
    static class Stack{
        static java.util.Deque<Integer> d = new LinkedList<>();

        public static void push(int data){
            d.addLast(data);
        }

        public static int pop(){
            return d.removeLast();
        }

        public static int peek(){
            return d.getLast();
        }
    }

    static class Queue{
        static java.util.Deque<Integer> d = new LinkedList<>();

        public static void add(int data){
            d.addLast(data);
        }

        public static int remove(){
            return d.removeFirst();
        }

        public static int peek(){
            return d.getFirst();
        }
    }
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        System.out.println();

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

    }
}
