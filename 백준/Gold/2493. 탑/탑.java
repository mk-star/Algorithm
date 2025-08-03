import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Stack<int[]> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty()) {
                if(stack.peek()[0] >= arr[i]) {
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) result.add(0);
            else result.add(stack.peek()[1]);
            stack.push(new int[] { arr[i], i + 1 });
        }

        for(int n : result) {
            System.out.print(n + " ");
        }
    }
}