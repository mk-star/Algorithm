import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Stack {
    int capacity;
    int top;
    int[] arr;

    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int data) {
        arr[++top] = data;
    }
    public int isEmpty() {
        if(top == -1) {
            return 1;
        }
        return 0;
    }
    public int pop() {
        if(isEmpty() == 1) {
            return -1;
        }
        return arr[top--];
    }
    public int peek() {
        if (isEmpty() == 1) {
            return -1;
        }
        return arr[top];
    }
    public int size() {
        return top + 1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack(n);
        for(int i = 0; i < n; i++) {
            StringTokenizer st  = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if(num == 2) {
                sb.append(stack.pop()).append("\n");
            } else if(num == 3) {
                sb.append(stack.size()).append("\n");
            } else if(num == 4) {
                sb.append(stack.isEmpty()).append("\n");
            } else if(num == 5) {
                sb.append(stack.peek()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}