package DynamicProgramming;

public class TribonacciNumbers {
    public static int triboNumber(int n){
        if(n==0 || n==1){
            return 0;
        }
        if (n==2){
            return 1;
        }
        return triboNumber(n-1) + triboNumber(n-2) + triboNumber(n-3);
    }
    public static int triboNum(int n, int dp[]){
        if(n==0 || n==1){
            return 0;
        }
        if (n==2){
            return 1;
        }
        if (dp[n] != -1){
            return dp[n];
        }
        return dp[n] = triboNum(n-1,dp) + triboNum(n-2,dp) + triboNum(n-3,dp);
    }
    public static int tribonacciNumber(int n){
        int dp[] = new int[n+1];
        dp[0]=dp[1]=0;
        dp[2] = 1;

        for (int i=3; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n = 5;

        System.out.println(tribonacciNumber(n));

        System.out.println(triboNumber(n));

        int dp[] = new int[n+1];
        for (int i=0; i<=n; i++){
            dp[i] = -1;
        }

        System.out.println(triboNum(n,dp));
    }

}
