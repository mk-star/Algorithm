import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] result;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();

    static void bfs() {
        while(!q.isEmpty()) {
            int[] tmp = q.poll();

            for(int t = 0; t < 4; t++) {
                int x = tmp[0] + dx[t];
                int y = tmp[1] + dy[t];

                if(x >= 0 && y >= 0 && x < N && y < M) {
                    if(!visited[x][y] && arr[x][y] == 0) {
                        visited[x][y] = true;
                        q.offer(new int[]{x, y});
                        arr[x][y] = arr[tmp[0]][tmp[1]] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 1) {
                    q.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
                cnt = Math.max(arr[i][j], cnt);
            }
        }
        System.out.println(cnt - 1);
    }
}