package Arrays;

public class BinarySearch {
    public static int binarySearch(int nums[], int key){ // TC = O(log2N
        int start=0, end= nums.length;
        while (start <= end){
            int mid = (start+end)/2;
            if (nums[mid] == key){
                return 1;
            }
            if (nums[mid] < key){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return  -1;
    }
    public static void main(String args[]){
        int nums[] = {2, 4, 6, 8, 10, 12, 14};
        int key = 5;
        int found = binarySearch(nums, key);

        if (found == 1){
            System.out.println("Key Found");
        } else {
            System.out.println("Key Not Found");
        }
    }
}
