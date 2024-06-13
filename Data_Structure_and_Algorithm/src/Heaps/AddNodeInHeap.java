package Heaps;

import java.util.ArrayList;

public class AddNodeInHeap { //O(logn)
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){ //O(1)
            // add at last idx
            arr.add(data);

            int x = arr.size()-1; // x is child idx
            int par = (x-1)/2; // parent idx

            while(arr.get(x) < arr.get(par)){ //O(logn)
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){ // O(logn)
            int left = 2*i+1;
            int right = 2*i+2;
            int mididx = i;

            if (left < arr.size() && arr.get(mididx) > arr.get(left)){
                mididx = left;
            }

            if (right < arr.size() && arr.get(mididx) > arr.get(right)){
                mididx = right;
            }

            if (mididx != i){
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(mididx));
                arr.set(mididx, temp);

                heapify(mididx);
            }
        }
        public int remove(){
            int data = arr.get(0);

            // step1 -  swap
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // step2 - delete
            arr.remove(arr.size()-1);

            // step3 - heapify
            heapify(0);
            return  data;
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    public static void main(String args[]){ // O(nlogn)
        Heap h = new Heap();

        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}
