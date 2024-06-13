package LinkedList;

import  java.util.LinkedList;
public class ClassRoom {
    public  static  void main(String args[]){
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(0);
        ll.add(2);
        ll.addLast(4);
        ll.addFirst(5);
        System.out.println(ll);

        ll.remove(0);
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
        ll.removeFirst();
        System.out.println(ll);


    }
}
