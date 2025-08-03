import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            map.put(num, i);
        }

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty()) {
                if(stack.peek() >= arr[i]) {
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) result.add(0);
            else result.add(map.get(stack.peek()) + 1);
            stack.push(arr[i]);
        }

        for(int n : result) {
            System.out.print(n + " ");
        }
    }
}