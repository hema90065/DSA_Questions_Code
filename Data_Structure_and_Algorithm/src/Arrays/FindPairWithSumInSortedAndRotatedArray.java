package Arrays;

public class FindPairWithSumInSortedAndRotatedArray {
    public static boolean pairInSortedRotated(int arr[], int sum){
        // Find the pivot element
        int i, n = arr.length;
        for (i=0; i<n; i++){
            if(arr[i] > arr[i+1]){
                break;
            }
        }
        int l = (i+1)%n;  // l is now index on minimum element
        int r = i;        // r is now index on maximum element

        // keep moving either l or r till they meet
        while (l != r){
            //if we find a pair with sum, we return true
            if(arr[l]+arr[r] == sum){
                return true;
            }

            // if current pair sum is less , move to the higher sum
            if(arr[l]+arr[r] < sum){
                l = (i+1)%n;
            } else { // move to the lower sum side
                r = (n+r-1)%n;
            }
        }
        return false;
    }
    public static void main(String args[]){
        int arr[] = {11, 15, 6, 8, 9, 10};
        int sum = 16;
        System.out.println(pairInSortedRotated(arr,sum));
    }
}
