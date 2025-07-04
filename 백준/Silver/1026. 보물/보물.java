import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		Integer[] B = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int j = 0; j < N; j++) {
			A[j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int j = 0; j < N; j++) {
			B[j] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B, (a, b) -> b - a);

		int result = 0;
		for(int i = 0; i < N; i++) {
			result += A[i] * B[i];
		}
		System.out.println(result);
    }
}