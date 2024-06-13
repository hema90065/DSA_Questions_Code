package Arrays;
import java.util.*;

public class MinimumElementInASortedAndRotatedArray {
    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while(left < right){

            int mid = left + (right - left)/2;

            // If the left half is sorted, the minimum element must be in the right half
            // If the right half is sorted, the minimum element must be in the left half

            if(nums[mid] > nums[right]){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
    public static void main(String[] args)
    {
        int nums[] = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(nums));
    }
}

