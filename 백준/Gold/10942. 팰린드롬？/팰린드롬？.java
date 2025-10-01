import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int isPalindrome(int start, int end) {
		int temp = end;
		for(int i = start; i <= end; i++) {
			if(temp == i) return 1;
			if(arr[i] != arr[temp--]) return 0;
		}
		return 1;
	}

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(isPalindrome(start, end)).append('\n');
		}
		System.out.println(sb);
	}
}