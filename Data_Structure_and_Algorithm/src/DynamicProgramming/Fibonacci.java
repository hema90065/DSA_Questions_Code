package DynamicProgramming;

public class Fibonacci {
    public static int fib(int n, int f[]){ // O(N)
        if (n == 1 || n == 0){
            return n;
        }
        if (f[n] != 0){  // fib(n) is already calculated
            return f[n];
        }

        f[n] = fib(n-1,f) + fib(n-2,f);
        return f[n];
    }
    public static int fibTabulation(int n){ //O(N)
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n = 6;
        int f[] = new int[n+1]; // 0, 0, 0, 0

        System.out.println(fib(n,f));
        System.out.println(fibTabulation(n));
    }
}
