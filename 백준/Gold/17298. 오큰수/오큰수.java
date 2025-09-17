import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

		int[] arr = new int[N];
		int[] result = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 초기값
		int index = N - 1;
		result[index--] = -1;
		stack.push(arr[N - 1]);

		for(int i = N - 2; i >= 0; i--) {
			int big;
			while((big = stack.peek()) <= arr[i]) {
				stack.pop();
				if(stack.isEmpty()) {
					big = -1;
					break;
				}
			}
			result[index--] = big;
			stack.push(arr[i]);
		}

		for(int i = 0; i < N; i++) {
			sb.append(result[i]).append(' ');
		}
        System.out.print(sb);
	}
}