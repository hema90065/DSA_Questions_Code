package Arrays;
import java.util.*;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                return true;
            } else{
                hm.put(nums[i], 1);
            }
        }
        return false;
    }
    public static void main(String args[]){
        int nums[] = {1,2,3,1};
        System.out.print(containsDuplicate(nums));
    }
}
