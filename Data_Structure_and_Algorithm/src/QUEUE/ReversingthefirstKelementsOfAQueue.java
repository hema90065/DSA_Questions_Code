package QUEUE;
import java.util.LinkedList;
import  java.util.Queue;
import java.util.Stack;



public class ReversingthefirstKelementsOfAQueue {
    public static void reverseFirstKElements(Queue<Integer> q, int k){
        Stack<Integer> s = new Stack<>();
        Queue<Integer> p = new LinkedList<>();
        int size = q.size();

        while (!q.isEmpty()){
            if(size>k) {
                s.push(q.remove());
            } else {
                p.add(q.remove());
            }
            size--;
        }

        while (!s.isEmpty()){
            q.add(s.pop());
        }

        while(!p.isEmpty()){
            q.add(p.remove());
        }

    }
    public static void main(String arg[]){

        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);

        reverseFirstKElements(q,5);

        while(!q.isEmpty()){
            System.out.print(q.remove()+ " ");
        }
    }
}
