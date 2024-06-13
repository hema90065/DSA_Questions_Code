package Hashing;

import java.util.HashMap;

public class LargestSubArrayWithSum0 {
    public static void main(String args[]){
        int arr[] ={15, -2, 2, -8, 1, 7, 10, 23};

        HashMap<Integer, Integer> map = new HashMap<>();
        // (sum, idx)
        int sum = 0;
        int len = 0;

        for (int j=0; j<arr.length; j++){
            sum += arr[j];
            if (map.containsKey(sum)){
                len = j - map.get(sum);
            } else {
                map.put(sum, j);
            }
        }

        System.out.print("Length of largest subarray with sum 0 = "+ len);
    }
}
