import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;

	static void backtracking(int depth, int idx) {
		if(depth == M) {
			for(int num : arr) {
				sb.append(num).append(' ');
			}
			sb.append('\n');

			return;
		}

		for(int i = idx; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				backtracking(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visited = new boolean[N + 1];

		backtracking(0, 1);

		System.out.println(sb);
	}
}