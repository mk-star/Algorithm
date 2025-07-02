import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] TArr = new int[T];

		long[] P = new long[101];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < T; i++) {
			TArr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, TArr[i]);
		}

		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		for(int i = 4; i <= max; i++) {
			P[i] = P[i - 3] + P[i - 2];
		}

		for(int i = 0; i < T; i++) {
			System.out.println(P[TArr[i]]);
		}
    }
}