import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}

		int max = 1;
		for(int i = 1; i < N; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(A[i] < A[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}