package Arrays;

import java.util.Arrays;

public class ChocolateDistributionProblem {
    // problem description - https://www.geeksforgeeks.org/chocolate-distribution-problem/
    public static int chocolateDistribution(int arr[], int m){
        Arrays.sort(arr);
        int minValue = Integer.MAX_VALUE;
        if(m> arr.length){
            return  -1;
        }
        for (int i=0; i<arr.length+1-m; i++){
            int currMin = arr[i+m-1] - arr[i];
            minValue = Math.min(minValue, currMin);
        }
        return minValue;
    }
    public static void main(String args[]){
        //int arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3;
        int arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5;
        System.out.print(chocolateDistribution(arr,m));
    }
}
