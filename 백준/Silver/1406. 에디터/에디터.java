import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] str = br.readLine().split("");

        int N = Integer.parseInt(br.readLine());

        Stack<String> left = new Stack<>();
        for(int i = 0; i < str.length; i++) {
			left.push(str[i]);
		}
        Stack<String> right = new Stack<>();

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch(command) {
                case "L":
                    if(!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case "D":
                    if(!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case "B": 
                    if(!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case "P":
                    left.push(st.nextToken());
                    break;
            }
        }
        while(!right.isEmpty()) {
            left.push(right.pop());
        }
        System.out.println(String.join("", left));
	}
}