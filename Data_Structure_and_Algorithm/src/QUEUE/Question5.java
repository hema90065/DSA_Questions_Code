package QUEUE;
import java.util.*;
public class Question5 {

    public static void interLeave(Queue q){
        Queue halfLeave = new LinkedList();
        int size = q.size();

        for(int i=0; i<size/2; i++){
            halfLeave.add(q.remove());
        }

        while (!halfLeave.isEmpty()){
            q.add(halfLeave.remove());
            q.add(q.remove());
        }
    }
    public static void main(String args[]){
        Queue q = new LinkedList();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interLeave(q);

        while (!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
