package Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productOfArrayExceptSelf(int nums[]){
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = nums[0];
        for (int i=1; i<n; i++){
            left[i] = nums[i]*left[i-1];
        }

        right[n-1] = nums[n-1];
        for (int i=n-2; i>0; i--){
            right[i] = nums[i]*right[i+1];
        }

        int op[] = new int[n];
        op[0]=right[1];
        op[n-1] = left[n-2];
        for (int i=1; i<n-1; i++){
            op[i] = left[i-1] * right[i+1];
        }
        return op;
    }
    public static void main(String args[]){ // TC = O(n), SC = O(n)
        int nums[] = {1, 2, 3, 4};
        int nums1[] = {-1,1,0,-3,3};

        int op[] = productOfArrayExceptSelf(nums);

        for (int i=0; i<nums.length; i++){
            System.out.print(op[i]+" ");
        }
    }
}
