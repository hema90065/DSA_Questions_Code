package QUEUE;
import java.util.PriorityQueue;
public class MaximumOfAllSubarraysOfSizeK {
    public static void maximumOfSubarry(int arr[], int n, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int currMax = 0;
        int len = n-k;
        for(int i=0; i<len; i++){
            int j = 0;
            k = 3;
            while(k>0){
                int x =i+j;
                //System.out.print(x + " ");
                pq.add(arr[x]);
                k--;
                j++;
                if(x==n-1){
                    break;
                }
            }
            while(!pq.isEmpty()){
                currMax = pq.peek();
                pq.poll();
            }
            if(pq.isEmpty()){
                System.out.print(currMax +" ");
            }
        }
    }
    public static void main(String args[]){
        int N=9, K=3;
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        maximumOfSubarry(arr,N,K);
    }
}
