package Arrays;

public class MaximumProductSubArray {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];

        for(int i=0; i<nums.length; i++){
            // if any of leftProduct or rightProduct is 0 then update it to 1
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct ==0 ? 1: rightProduct;

            // prefix product
            leftProduct *= nums[i];

            // suffix product
            rightProduct *= nums[n-1-i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }
        return ans;
    }

    public static void main(String args[]){
        int nums[] = {2,3,-2,4};
        int nums1[] = {-2,0,-1};

        System.out.println(maxProduct(nums));
        System.out.println(maxProduct(nums1));
    }
}
