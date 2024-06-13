package Hashing;

import java.util.HashMap;

public class SubArraySumEqualToK {
    public static void main(String args[]){ // O(n)
        int arr[] = {10, 2, -2, -20, 10};
        int k = 10;

        HashMap<Integer, Integer> map = new HashMap<>();
        // (sum, freq)
        map.put(0,1);

        // sum(j) - sum(i) = k
        int sum = 0;
        int ans = 0;

        for (int j=0; j< arr.length; j++){
            sum += arr[j]; // sum(j)
            if (map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        System.out.println(ans);
    }
}
