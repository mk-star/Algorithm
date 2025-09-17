import java.io.*;
import java.util.*;

class Point {
	long num;
	int cnt;

	Point(long num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}

}

public class Main {
	static int B;
	static int min = Integer.MAX_VALUE;
	static boolean flag = false;

	static void bfs(int start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(start, 0));

		while(!queue.isEmpty()) {
			Point point = queue.poll();

			long num = point.num;
			int cnt = point.cnt;

			if(num > B) continue;
			
			if(num == B) min = Math.min(min, cnt + 1);

			if(num * 2 <= B) queue.offer(new Point(num * 2, cnt + 1));
			if(num * 10 + 1 <= B) queue.offer(new Point(num * 10 + 1, cnt + 1));
		}
	}

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		bfs(A);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
}