import java.util.*;
import java.io.*;

// x - 2 y + 1
// x - 2 y - 1
// x - 1 y + 2
// x - 1 y - 2
// x + 1 y + 2
// x + 1 y - 2
// x + 2 y + 1
// x + 2 y - 1

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int l;
    static int targetX, targetY;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

    static int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j, 0});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
   
            if(tmp[0] == targetX && tmp[1] == targetY) {
                return tmp[2];
            }

            for(int t = 0; t < 8; t++) {
                int x = tmp[0] + dx[t];
                int y = tmp[1] + dy[t];
                int cnt = tmp[2];

                if(x >= 0 && x < l && y >= 0 && y < l) {
                    if(!visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(new int[] {x, y, cnt + 1});
                    }
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            arr = new int[l][l];
            visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int nowX = Integer.parseInt(st.nextToken());
            int nowY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(nowX, nowY));
        }
    }
}

