package Arrays;

public class MaxSumOfSubarrayUsingPrefixArray {
    public static void printSubArray(int arr[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new  int[arr.length];
        prefix[0] = arr[0];
        // calculation of prefix sum
        for (int i=1; i<arr.length; i++){
            prefix[i] = arr[i] + prefix[i-1];
        }
        for (int i=0; i<arr.length; i++){
            int start = i;
            for (int j=i; j<arr.length; j++){
                int end = j;
                currSum = start==0 ? prefix[end] : prefix[end]-prefix[start-1];
            }
            maxSum = Math.max(currSum,maxSum);
        }
        System.out.print(maxSum);
    }
    public static void main(String args[]){
        int arr[] = { 1, -2, 6, -1, 3};
        printSubArray(arr);
    }
}
