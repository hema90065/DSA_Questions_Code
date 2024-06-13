package QUEUE;

import java.util.PriorityQueue;

public class PriorityQueuepq {
    public static int minCost(int arr[], int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.add(arr[i]);
        }

        int res = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            //System.out.println("first = " +first);
            int second = pq.poll();
            //System.out.println("Second = " + second);
            res += first + second;
            //System.out.println("res = "+ res);
            pq.add(first + second);
        }
        return res;

    }
    public static void main(String args[]){
        int arr[] = {4, 3, 2, 6};
        int size = arr.length;

        minCost(arr,size);
        System.out.println("Total cost for connecting"+ " ropes is "+ minCost(arr, size));

    }
}
