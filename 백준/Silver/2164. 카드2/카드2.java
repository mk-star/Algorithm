import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        Queue<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while(q.size() != 1) {
            q.poll();
            if(q.size() == 1) break;
            q.offer(q.poll());
        }
        System.out.println(q.peek());
    }
}


