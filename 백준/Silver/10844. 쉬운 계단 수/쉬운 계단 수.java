import java.io.*;

public class Main {
    final static long MOD = 1000000000;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // N 자릿수에 자릿값
        long[][] dp = new long[N + 1][10];

        // 첫 번째 자릿수는 1개씩
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1; 
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][1] % MOD;
                } else if(j == 9) {
                    dp[i][j] = dp[i - 1][8] % MOD;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1] % MOD;
                }
            }
        }

        // 각 자릿값마다의 경우의 수
        long sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += dp[N][i];
		}
		
        System.out.println(sum % MOD);
		
	}
}