import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		for(int i = 2; i <= N; i++) {
			queue.offer(i);
		}
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int prime = queue.poll();
			cnt++;
			if(K == cnt) {
				System.out.println(prime);
				System.exit(0);
			}

			int temp = cnt;
			for(int i = 1; i < N - cnt; i++) {
				if(queue.peek() % prime == 0) {
					int mul = queue.poll();
					temp++;
					if(K == temp) {
						System.out.println(mul);
						System.exit(0);
					}
				} else {
					queue.offer(queue.poll());
					
				}
			}
			cnt = temp;
		}
	}
}