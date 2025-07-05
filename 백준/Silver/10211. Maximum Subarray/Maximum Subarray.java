import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] X = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp = new int[N]; // i번째 요소까지 더했을 때 최대 부분합 저장
			dp[0] = X[0];
			int max = X[0];

			for(int i = 1; i < N; i++) {
				if(dp[i - 1] < 0) dp[i - 1] = 0;
				dp[i] = dp[i - 1] + X[i];
				max = Math.max(max, dp[i]); // 이전 부분 합을 합하는 게 큰지, 버리는 게 큰지
			}
			System.out.println(max);
		}
	}
}