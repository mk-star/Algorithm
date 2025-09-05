import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder result = new StringBuilder();

    static void solution(String str) {
        StringBuilder sb = new StringBuilder();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '<') { // 커서 왼쪽에 있는 걸 오른쪽으로 이동
                if(!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if(str.charAt(i) == '>') { // 커서 오른쪽에 있는 걸 왼쪽으로 이동
                if(!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if(str.charAt(i) == '-') {
                if(!left.isEmpty()) {
                    left.pop();
                }
            } else {
                left.push(str.charAt(i)); // 커서 왼쪽에 푸시
            }
        }
        while (!right.isEmpty()) {
			left.push(right.pop());
		}

        while(!left.isEmpty()) {
            sb.append(left.pop());
        }
        result.append(sb.reverse()).append("\n");
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String str = br.readLine();
            solution(str);
        }
        System.out.println(result);
	}
}