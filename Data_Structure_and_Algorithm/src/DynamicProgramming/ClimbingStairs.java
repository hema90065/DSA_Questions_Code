package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
    public static int countWays(int n){ //O(2^n)
        if(n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        return countWays(n-1) + countWays(n-2);
    }
    public static int countWaysMemoization(int n, int ways[]){ // O(n)
        if(n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        if (ways[n] != -1){
            return ways[n];
        }
        ways[n] = countWaysMemoization(n-1,ways) + countWaysMemoization(n-2, ways);
        return ways[n];
    }
    // Tabulation
    public static int countwaysTab(int n){ //O(n)
        int dp[] = new int[n+1];
        dp[0] = 1;

        for (int i=1; i<=n; i++){
            if (i==1){
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n=5;  // n=3 -> 3, n=4 -> 5 => 8
        System.out.println(countWays(n));

        int ways[] = new int[n+1];
        Arrays.fill(ways,-1);
        System.out.println(countWaysMemoization(n,ways));

        System.out.println(countwaysTab(n));
    }
}
