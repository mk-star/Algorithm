import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();

		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) stack.pop();
			else stack.push(n);
		}

		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}