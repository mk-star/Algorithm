import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] graph;
    static int[] dx = { 1, 1, 1 };
    static int[] dy = { -1, 0, 1 };
    static int min = Integer.MAX_VALUE;

    static void dfs(int x, int y, int depth, int sum, int dir) {
        if(depth == N - 1) {
            min = Math.min(min, sum);
            return;
        }

        // 세 방향
        for(int i = 0; i < 3; i++) {
            if(i == dir) continue;

            int tx = x + dx[i];
            int ty = y + dy[i];

            if(tx >= 0 && ty >= 0 && tx < N && ty < M) {
                dfs(tx, ty, depth + 1, sum + graph[tx][ty], i);
            }
        }
    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            dfs(0, i, 0, graph[0][i], 4);
        }

        System.out.println(min);

	}
}