import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] pick = new int[M];
        for(int i = 0; i < M; i++) {
            pick[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }

        int cnt = 0;
        for(int i = 0; i < M; i++) {
            if(deque.indexOf(pick[i]) <= deque.size() / 2) {
                while(deque.peekFirst() != pick[i]) {
                    // 2번째 연산 수행
                    deque.offerLast(deque.pollFirst());
                    cnt++;
                }
            } else {
                while(deque.peekFirst() != pick[i]) {
                    // 3번째 연산 수행
                    deque.offerFirst(deque.pollLast());
                    cnt++;
                }
            }
            // 1번째 연산 수행
            deque.pollFirst();
        }
        System.out.println(cnt);
	}
}