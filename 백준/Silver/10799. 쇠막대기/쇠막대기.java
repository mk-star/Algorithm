import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<String> stack = new Stack<>();

		String[] s = br.readLine().split("");

		int cnt = 0;
		for(int i = 0; i < s.length; i++) {
			if(s[i].equals("(")) {
				stack.push(s[i]);
			}
			
			if(s[i].equals(")")) {
				stack.pop();
				if(s[i - 1].equals("(")) {
					cnt += stack.size();
				} else {
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}
}