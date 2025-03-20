import java.io.*;
import java.util.*;
public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int N;

    static void bfs(int idx) {
        visited[idx] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);

        while(!q.isEmpty()) {
            int n = q.poll();
            for(int i = 1; i <= N; i++) {
                if(!visited[i] && arr[n][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1][N + 1];
            visited = new boolean[N + 1];
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                arr[j][Integer.parseInt(st.nextToken())] = 1;
            }
            for(int j = 1; j <= N; j++) {
                if(!visited[j]) {
                    bfs(j);
                    cnt++;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}
