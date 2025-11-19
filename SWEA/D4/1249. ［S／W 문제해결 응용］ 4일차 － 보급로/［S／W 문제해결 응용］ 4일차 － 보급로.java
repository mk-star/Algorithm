import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int x;
    int y;
    int w;

    Node(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    @Override
    public int compareTo(Node n) {
        return this.w - n.w;
    }
}

class Solution {
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static void dijkstra(int posX, int posY) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(posX, posY, 0));
        visited[posX][posY] = true;
        dist[posX][posY] = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for(int i = 0; i < 4; i++) {
                int x = dx[i] + cur.x;
                int y = dy[i] + cur.y;
                
                if(x >= 0 && y >= 0 && x < N && y < N) {
                    if(!visited[x][y] && dist[cur.x][cur.y] + graph[x][y] < dist[x][y]) { 
                        visited[x][y] = true;
                        dist[x][y] = dist[cur.x][cur.y] + graph[x][y];             
                        pq.offer(new Node(x, y, dist[x][y]));
                    }
                }
            }
        }
    }


	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            graph = new int[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];

            for(int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            
            for(int i = 0; i < N; i++) {
                String s = br.readLine();
                for(int j = 0; j < N; j++) {
                    graph[i][j] = s.charAt(j) - '0';
                }
            }

            dijkstra(0, 0);

            result.append('#').append(test_case).append(' ').append(dist[N - 1][N - 1]).append('\n');
		}

        System.out.println(result);
	}
}