import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    // 덩어리 개수를 구함
    static void bfs(int posX, int posY) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] { posX, posY });
        visited[posX][posY] = true;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i = 0; i < 4; i++) {
                int x = dx[i] + temp[0];
                int y = dy[i] + temp[1];

                if(x >= 0 && y >= 0 && x < N && y < M) {
                    if(arr[x][y] != 0 && !visited[x][y]) {
                        queue.offer(new int[] { x, y });
                        visited[x][y] = true;
                    }
                }
            }
        }
    }

    // 빙산의 높이를 감소시킴
    static void decreaseIcebergHeight(int[][] arr) {
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && arr[i][j] == 0) {
                    for(int k = 0; k < 4; k++) {
                        int x = dx[k] + i;
                        int y = dy[k] + j;

                        if(x >= 0 && y >= 0 && x < N && y < M) {
                            if(arr[x][y] > 0) {
                                arr[x][y]--;
                                visited[x][y] = true;
                            }
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

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while(true) {
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(!visited[i][j] && arr[i][j] != 0) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            visited = new boolean[N][M];

            // 전부 녹았다면 0을 출력
            if(cnt == 0) {
                result = 0;
                break;
            }
            
            // 두 덩어리 이상으로 분리
            if(cnt >= 2) break;

            result++;
            decreaseIcebergHeight(arr);

        }
        System.out.println(result);
	}
}