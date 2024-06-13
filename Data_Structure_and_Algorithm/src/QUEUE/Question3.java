package QUEUE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Queue;

public class Question3 {
    // implementation of stack using 2 queue
    static class Stack{
        static java.util.Queue<Integer> q1 = new LinkedList<>();
        static java.util.Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        //add
        public static void add(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        //pop
        public static int pop(){
            int top = -1;
            //case1
            if(!q1.isEmpty()){
                while (!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            } else { //case2
                while (!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        //peek
        public static int peek(){
            int top = -1;
            //case1
            if(!q1.isEmpty()){
                while (!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                    }
            } else { //case2
                while (!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void main(String args[]){
        Stack q = new Stack();

        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.pop();
        }

    }
}
