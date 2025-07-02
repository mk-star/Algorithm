import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		long[] P = new long[101];
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());

			P[1] = 1;
			P[2] = 1;
			P[3] = 1;
			for(int j = 4; j <= n; j++) {
				P[j] = P[j - 3] + P[j - 2];
			}
			System.out.println(P[n]);
		}
    }
}