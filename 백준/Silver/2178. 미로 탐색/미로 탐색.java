import java.io.*;
import java.util.*;

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] graph;
    static int[][] result;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(int i, int j) {
        visited[i][j] = true;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j));

        while(!q.isEmpty()) {
            Node n = q.poll();

            for(int k = 0; k < 4; k++) {
                int x = n.x + dx[k];
                int y = n.y + dy[k];

                if(x >= 0 && x < N && y >= 0 && y < M) {
                    if(graph[x][y] == 1 && !visited[x][y]) {
                        result[x][y] = result[n.x][n.y] + 1;
                        visited[x][y] = true;
                        q.offer(new Node(x, y));
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
        visited = new boolean[N][M];
        result = new int[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++)
                graph[i][j] = s.charAt(j) - '0';
        }
        bfs(0, 0);
        System.out.println(result[N - 1][M - 1] + 1);
    }
}
