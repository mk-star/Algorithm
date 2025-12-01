import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    
    static int visitOrNotVisit(int curX, int curY, boolean flag) {
        visited[curX][curY] = flag;

        int cost = arr[curX][curY];
        
        for(int i = 0; i < 4; i++) {
            int x = dx[i] + curX;
            int y = dy[i] + curY;

            if(x >= 0 && x < N && y >= 0 && y < N) {
                cost += arr[x][y];
                visited[x][y] = flag;
            }
        }

        return cost;
    }

    static boolean isVisit(int curX, int curY) {
        for(int i = 0; i < 4; i++) {
            int x = dx[i] + curX;
            int y = dy[i] + curY;

            if(x >= 0 && x < N && y >= 0 && y < N) {
                if(visited[x][y]) return false;
            }
        }
        return true;
    }
    
    static void backTracking(int depth, int r, int cost) {
        // 3번 뽑으면 비용 검사
        if(depth == r) {
            //System.out.println(cost);
            min = Math.min(min, cost);
            return;
        }
 
        for(int i = 1; i < N - 1; i++) {
            for(int j = 1; j < N - 1; j++) {
                // 방문 체크
                if(isVisit(i, j)) {
                    backTracking(depth + 1, r, cost + visitOrNotVisit(i, j, true));
                    visitOrNotVisit(i, j, false);
                }
            }
        }     
    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        backTracking(0, 3, 0);

        System.out.println(min);
	}
}