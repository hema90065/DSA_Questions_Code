package DynamicProgramming;

public class RodCutting {
    public static int maximumValue(int len[], int prices[], int rodLen){
        int n = len.length;
        int dp[][] = new int[n+1][rodLen+1];
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                int length = len[i-1];
                int price = prices[i-1];
                if (length<=j){
                    int incProfit = price + dp[i][j-length];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][rodLen];
    }
    public static void main(String args[]){
        int len[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLen = 8;

        System.out.println(maximumValue(len, price, rodLen));
    }
}
