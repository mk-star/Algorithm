import java.io.*;
import java.util.*;

public class Main {
	static int dp[][][] =  new int[21][21][21];
	
	static int w(int a, int b, int c) { 
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
	
		if(a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}

		if(dp[a][b][c] != 0) {
			return dp[a][b][c];
		}

		if(a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}

	static void printResult(int a, int b, int c, int result) {
		System.out.print("w(");
		System.out.print(a + ", " + b + ", " + c);
		System.out.print(") = ");
		System.out.println(result);
	}

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		while(a != -1 || b != -1 || c != -1) {
			int result = w(a, b, c);

			printResult(a, b, c, result);
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
	}
}
