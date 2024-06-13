package Heaps;

public class MaxSum {
    public static void main(String args[]){
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k=3, max= Integer.MIN_VALUE;

        for (int i=0; i< arr.length-k+1; i++ ){
            max = Math.max(arr[i], Math.max(arr[i+1],arr[i+2]));
            System.out.print(max + " ");
        }
    }
}
