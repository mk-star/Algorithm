import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int N;

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : graph.get(cur)) {
                if(next == end) return 1;

                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int edge = Integer.parseInt(st.nextToken());
                if(edge == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(bfs(i, j) + " ");
            }
            System.out.println();
        }
	}
}