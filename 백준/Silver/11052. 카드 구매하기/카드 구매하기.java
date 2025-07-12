import java.io.*;
import java.util.*;

public class Main {	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N + 1];
		int[] dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
			dp[i] = P[i];
		}

		for(int i = 2; i <= N; i++) {
			for(int j = 1; j <= i / 2; j++) {
				dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
			}
		}
		System.out.println(dp[N]);
	}
}
