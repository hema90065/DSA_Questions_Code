package DynamicProgramming;

public class TargetSumSubset {
    // Tabulation
    public static void print(boolean dp[][]){
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
               if (dp[i][j] == true){
                   System.out.print("T ");
               } else {
                   System.out.print("F ");
               }
            }
            System.out.println();
        }
    }
    public static boolean targetSum(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[arr.length+1][sum+1];

        // i = items & j = target sum
        for (int i=0; i<=n; i++){
            dp[i][0] = true;
        }

        for (int i=1; i< dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                int v = arr[i-1];
                if (v<=j && dp[i-1][j-v]== true){ // include
                    dp[i][j] = true;
                } else if (dp[i-1][j] == true) { // exclude
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }
    public static void main(String args[]){
        int arr[] = {4, 2, 7, 1, 3};
        int sum = 10;

        System.out.print(targetSum(arr,sum));
    }
}
