package Arrays;

public class MaximumSubArraySum {
    public static void maxSubArraySum(int arr[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++){
            int start = i;
            for (int j=i; j<arr.length; j++){
                int end = j;
                currSum = 0;
                for (int k=start; k<=end; k++){
                    System.out.print(arr[k]+" ");
                    currSum+=arr[k];
                }
                System.out.println();
                maxSum = Math.max(currSum,maxSum);
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
    public static void main(String args[]){
        int arr[] = { 5, 2, 8, 3, 7};
        maxSubArraySum(arr);
    }
}
