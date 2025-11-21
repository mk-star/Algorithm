import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;
	static boolean[][] visited;
	static int[][] graph;
	
	static int bfs(int startX, int startY, int endX, int endY) {
		Queue<int[]> queue = new LinkedList<>();
		visited[startX][startY] = true;
		queue.offer(new int[] { startX, startY });
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int x = dx[i] + temp[0];
				int y = dy[i] + temp[1];

				if(x == endX && y == endY) return 1;
				
				if(x >= 0 && y >= 0 && x < N && y < N) {
					if(!visited[x][y] && graph[x][y] != 1) {
						visited[x][y] = true;
						queue.offer(new int[] { x, y });
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			
			int T = Integer.parseInt(br.readLine());
			
			N = 16;
			
			graph = new int[N][N];
			visited = new boolean[N][N];
			
			int startX = 0, startY = 0;
			int endX = 0, endY = 0;
			
			for(int i = 0; i < N; i++) {
				String[] s = br.readLine().split("");
				for(int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(s[j]);
					
					
					if(graph[i][j] == 2) {
						startX = i;
						startY = j;
					}
					
					if(graph[i][j] == 3) {
						endX = i;
						endY = j;
					}
				}
			}

			sb.append('#').append(T).append(' ').append(bfs(startX, startY, endX, endY)).append('\n');
			
		}
		
		System.out.println(sb);
	}
}
