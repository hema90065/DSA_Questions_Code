package QUEUE;
import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class QueueReverse {

    public static void queueReverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        while (!q.isEmpty()){
            s.push(q.remove());
        }
        while (!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String args[]){
        Queue<Integer> q = new LinkedList();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        queueReverse(q);

        while (!q.isEmpty()){
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();
    }
}
