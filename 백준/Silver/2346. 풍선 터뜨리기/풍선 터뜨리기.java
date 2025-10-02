import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<int[]> deque = new ArrayDeque<>();

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			deque.offer(new int[] { i + 1, arr[i]});
		}

		StringBuilder sb = new StringBuilder();

		int cur = deque.poll()[1];
		sb.append(1).append(' ');
		while(!deque.isEmpty()) {
			// 양수인 경우
			if(cur > 0) {
				for(int i = 1; i < cur; i++) deque.offer(deque.poll());
				int[] next = deque.poll();
				cur = next[1];
				sb.append(next[0]).append(' ');
			} else { // 음수인 경우
				for(int i = 1; i < -cur; i++) deque.offerFirst(deque.pollLast());
				int[] next = deque.pollLast();
				cur = next[1];
				sb.append(next[0]).append(' ');
			}
		}
		System.out.println(sb);
	}
}