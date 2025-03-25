import java.io.*;
// Fn = Fn-1 + Fn-2
// dp[n] -> n번째 피보나치 수 
public class Main {
    static long[] dp;
    static long fibo(int n) {
        if(n == 0 || n == 1) return dp[n];

        if(dp[n - 1] == -1)
            dp[n - 1] = fibo(n - 1);

        if(dp[n - 2] == -1)
            dp[n - 2] = fibo(n - 2);
        
        dp[n] = dp[n - 1] + dp[n - 2];
        return dp[n];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < n; i++) dp[i] = -1;
 
        fibo(n);
        System.out.println(dp[n]);
    }
}
