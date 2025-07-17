import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
       
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq  = new PriorityQueue<>(); // 끝나는 시간 순으로 오름차순
        pq.add(arr[0][1]);
        for(int i = 1; i < N; i++) {
            if(arr[i][0] >= pq.peek()) { // 가장 빨리 끝나는 강의가 이번 강의 시작 전에 끝났으면 제거.
                pq.poll(); 
            }
            pq.offer(arr[i][1]);
        }
        System.out.println(pq.size());
    }
}