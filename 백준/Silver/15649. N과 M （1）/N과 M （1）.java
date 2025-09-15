import java.io.*;
import java.util.*;
public class Main { 
	static int N, M;
	static boolean[] visited;
	static int[] orders;
	static StringBuilder sb;
	static int start = 1;

	static void permutation(int depth, int idx) {
		if(depth == M) {
			for(int i = 1; i <= N; i++) {
				if(orders[i] != 0) sb.append(orders[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				orders[idx] = i;
				permutation(depth + 1, idx + 1);
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

		visited = new boolean[N + 1];
		orders = new int[N + 1];
		
		permutation(0, 1);
		System.out.println(sb);
	}
}