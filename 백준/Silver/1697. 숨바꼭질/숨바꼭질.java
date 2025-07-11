import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static boolean[] visited;

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {N, 0});
		visited[N] = true;

		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int n = curr[0];
			int t = curr[1];

			if(n == K) {
				System.out.println(t);
				return;
			}

			for(int i = 0; i < 3; i++) {
				int next;
                if (i == 0) {
                    next = n + 1;
                } else if (i == 1) {
                    next = n - 1;
                } else {
                    next = n * 2;
                }

                if (next >= 0 && next <= 100000 && !visited[next]) {
					q.offer(new int[]{next, t + 1});
					visited[next] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];

		bfs();
	}
}
