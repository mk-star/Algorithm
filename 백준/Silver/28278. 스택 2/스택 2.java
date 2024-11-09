import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            int num = Integer.parseInt(str.substring(0, 1));
            if(num == 1) {
                stack.push(Integer.parseInt(str.substring(2)));
            } else if(num == 2) {
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            } else if(num == 3) {
                sb.append(stack.size()).append("\n");
            } else if(num == 4) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            } else if(num == 5) {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}