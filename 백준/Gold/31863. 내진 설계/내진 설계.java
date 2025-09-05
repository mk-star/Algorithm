import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startX][startY] = true;

        for(int i = 0; i < 4; i++) {
            int x = dx[i] + startX;
            int y = dy[i] + startY;

            if(x >= 0 && y >= 0 && x < N && y < M) {
                if(graph[x][y] != '|') {
                    if(x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < N && y + dy[i] < M) {
                        if(graph[x + dx[i]][y + dy[i]] == '#') {
                            graph[x + dx[i]][y + dy[i]] = '*';
                        } else if(graph[x + dx[i]][y + dy[i]] == '*') {
                            queue.offer(new int[]{x + dx[i], y + dy[i]});
                            visited[x + dx[i]][y + dy[i]] = true;
                        }
                    }
                        
                    if(graph[x][y] == '#') graph[x][y] = '*';
                    else if(graph[x][y] == '*') {
                        queue.offer(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i = 0; i < 4; i++) {
                int x = dx[i] + temp[0];
                int y = dy[i] + temp[1];

                if(x >= 0 && y >= 0 && x < N && y < M) {
                    if(!visited[x][y]) {
                        if(graph[x][y] == '#') graph[x][y] = '*';
                        else if(graph[x][y] == '*') {
                            queue.offer(new int[] {x, y});
                            visited[x][y] = true;
                        }
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
        
        graph = new char[N][M];
        visited = new boolean[N][M];
        int startX = 0, startY = 0;

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j);
                if(graph[i][j] == '@') {
                    startX = i; startY = j;
                }
            }
        }
        
        bfs(startX, startY);

        int cnt1 = 0, cnt2 = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j] && graph[i][j] != '@') cnt1++;
                else if(graph[i][j] == '*' || graph[i][j] == '#') cnt2++;
            }
        }
        System.out.println(cnt1 + " " + cnt2);
	}
}