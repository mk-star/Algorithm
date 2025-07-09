import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) > Math.abs(o2)) {
					// -3 -1일 때, -1 -3으로 정렬 
					return Math.abs(o1) - Math.abs(o2);
				} else if(Math.abs(o1) == Math.abs(o2)) {
					// 3 -3일 때, -3 3으로 정렬 
					return o1 - o2;
				} else { // -1 -3일 때, 그대로
					return -1;
				}
			}
		});

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			} else {
				pq.offer(x);
			}
		}

		System.out.println(sb);
	}
}
