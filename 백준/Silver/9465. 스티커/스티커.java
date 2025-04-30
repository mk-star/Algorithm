import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] s = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
    
            for(int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= n; j++) {
                    s[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        
            dp[0][1] = s[0][1];
            dp[1][1] = s[1][1];
            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + s[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + s[1][j];
            }

            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }
        System.out.println(sb);
    }
}