import java.io.*;
import java.util.*;
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[][] wall_visited;
    static boolean[] visited;
    static ArrayList<Point> wall;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    static void solution(int index, int depth) {
        if(depth == 3) {
            wall_visited = new boolean[N][M];
            for(int i = 0; i < wall.size(); i++) {
                if(visited[i]) {
                    wall_visited[wall.get(i).x][wall.get(i).y] = true;
                }
            }
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(graph[i][j] == 2) {
                        bfs(i, j);
                    }
                }
            }

            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(!wall_visited[i][j] && graph[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            max = Math.max(max, cnt);
            return;
        }

        for(int i = index; i < wall.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                solution(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        wall_visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            for(int t = 0; t < 4; t++) {
                int x = dx[t] + temp[0];
                int y = dy[t] + temp[1];

                if(x >= 0 && y >= 0 && x < N && y < M) {
                    if(!wall_visited[x][y] && graph[x][y] == 0) {
                        queue.offer(new int[]{x, y});
                        wall_visited[x][y] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        wall = new ArrayList<>();
        wall_visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) {
                    wall.add(new Point(i, j));
                }
                graph[i][j] = num;
            }
        }
        visited = new boolean[wall.size()];

        solution(0, 0);

        System.out.println(max);
	}
}