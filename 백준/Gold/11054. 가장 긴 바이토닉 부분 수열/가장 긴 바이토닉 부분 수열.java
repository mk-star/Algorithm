import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			dp1[i] = dp2[i] = 1;
		}

		for(int i = 1; i < N; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(A[i] > A[j]) {
					dp1[i] = Math.max(dp1[i], dp1[j] + 1);
				}
			}
		}

		for(int i = N - 2; i >= 0; i--) {
			for(int j = i + 1; j < N; j++) {
				if(A[i] > A[j]) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				}
			}
		}

		int max = 1;
		for(int i = 0; i < N; i++) {
			max = Math.max(dp1[i] + dp2[i] - 1, max);
		}
		System.out.println(max);
	}
}