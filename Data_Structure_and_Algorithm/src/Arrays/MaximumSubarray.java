package Arrays;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {

        // Check All Elements of Array - Negative
        boolean negEle = true;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            min = Math.min(min, Math.abs(nums[i]));
            if(nums[i]>0){
                negEle = false;
            }
        }
        if(negEle == true){
            return -min;
        }

        // Check All Elements of Array - Positive
        int sum=0;
        boolean posEle = true;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(nums[i]>0){
                posEle = false;
            }
        }

        if(sum<0 && posEle == true){
            return sum;
        } else {
            // Elements of array are negative and positive
            int cs = 0;
            int ms = Integer.MIN_VALUE;
            for(int i=0; i<nums.length; i++){
                cs+=nums[i];
                if(cs<0){
                    cs=0;
                }
                ms=Math.max(ms,cs);
            }
            return ms;
        }
    }

    public static void main(String args[]){
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

        int nums1[] = {1,2,3,4};
        System.out.println(maxSubArray(nums1));

        int nums2[] = {-3,-1};
        System.out.println(maxSubArray(nums2));

        int nums3[] = {1};
        System.out.println(maxSubArray(nums3));
    }
}
