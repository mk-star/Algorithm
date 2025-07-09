import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] map, result;
	static boolean[][] visited; 
	static int[] dx = {-1, 1, 0, 0}; 
	static int[] dy = {0, 0, -1, 1};

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x, y});
		visited[x][y] = true;

		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i = 0; i < 4; i++) {
				int xi = dx[i] + tmp[0];
				int yi = dy[i] + tmp[1];
				
				if(xi >= 0 && yi >= 0 && xi < n && yi < m) {
					if(!visited[xi][yi] && map[xi][yi] == 1) {
						visited[xi][yi] = true;
						result[xi][yi] = result[tmp[0]][tmp[1]] + 1;
						q.offer(new int[]{xi, yi});
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		result = new int[n][m];
		visited = new boolean[n][m];
		int tx = 0, ty = 0;

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					result[i][j] = 0;
				} else if(map[i][j] == 2) {
					tx = i; ty = j;
					result[i][j] = 0;
				} else {
					result[i][j] = -1;
				}
			}
		}

		bfs(tx, ty);

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
