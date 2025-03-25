import java.io.*;
// Fn = Fn-1 + Fn-2
// dp[n] -> n번째 피보나치 수 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
 
        for(int i = 2; i <= n; i++) { 
			dp[i] = dp[i - 1] + dp[i - 2];
		}
        System.out.println(dp[n]);
    }
}
