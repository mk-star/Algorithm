import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int dp[] = new int[5001];

        dp[3] = 1;
        dp[5] = 1;
        for(int i = 6; i <= N; i++) {
            if(dp[i - 5] != 0 && dp[i - 3] != 0) dp[i] = Math.min(dp[i - 5], dp[i - 3]) + 1;
            else if(dp[i - 5] != 0) dp[i] = dp[i - 5] + 1;
            else if(dp[i - 3] != 0) dp[i] = dp[i - 3] + 1;
        }

        System.out.println(dp[N] == 0 ? -1 : dp[N]);
    }
}