package DynamicProgramming;

public class Knapsack {
    public static int maxProfit(int val[], int wt[], int w, int n){ // O(2^n)
        if (w == 0 || n == 0){
            return 0;
        }

        if (wt[n-1] <= w){ // valid
            // include item
            int ans1 = val[n-1] + maxProfit(val, wt, w-wt[n-1], n-1);
            // not include
            int ans2 = maxProfit(val, wt, w, n-1);
            return Math.max(ans1, ans2);
        } else { // not valid
            return maxProfit(val, wt, w, n-1);
        }
    }

    //Memoization => TC - O(n*w)
    public static int maxProfitMemo(int val[], int wt[], int w, int n, int dp[][]){
        if (w == 0 || n == 0){
            return 0;
        }

        if (dp[n][w] != -1){
            return dp[n][w];
        }

        if (wt[n-1] <= w){ // valid
            // include item
            int ans1 = val[n-1] + maxProfitMemo(val, wt, w-wt[n-1], n-1, dp);
            // not include
            int ans2 = maxProfitMemo(val, wt, w, n-1,dp);
            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];
        } else { // not valid
            dp[n][w] = maxProfitMemo(val, wt, w, n-1,dp);
            return dp[n][w];
        }
    }
    public static void print(int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Tabulation
    public static int knapsackTab(int val[], int wt[], int W, int n){
        int dp[][] = new int[n+1][W+1];
        for (int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for (int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                int v = val[i-1]; // ith item value
                int w = wt[i-1]; // ith item wt
                if(w<=j){ // valid
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][w];
                    dp[i][j] = Math.max(incProfit,excProfit);
                } else { // not valid
                    int excProfit = dp[i-1][w];
                    dp[i][j] = excProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
    }
    public static void main(String args[]){
        int val[] = {15, 14, 10, 45,30};
        int wt[] = {2,5,1,3,4};
        int w = 7;

        int dp[][] = new int[val.length+1][w+1];
        for (int i=0; i< dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

         //System.out.println(maxProfitMemo(val, wt, w, val.length,dp));
        System.out.println(knapsackTab(val,wt,w,5));
    }
}
