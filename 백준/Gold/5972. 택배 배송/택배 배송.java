import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int weight;

    Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n) {
        return this.weight - n.weight;
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static int N;
    static int[] dist;

    static int dijkstra(int start) {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        dist[start] = 0;
        visited[start] = true;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            for(Node n : graph.get(cur.index)) {
                if(!visited[n.index] && dist[n.index] > dist[cur.index] + n.weight) {
                    // weight를 갱신
                    dist[n.index] = dist[cur.index] + n.weight;
                    pq.offer(new Node(n.index, dist[n.index]));

                }
            }
        }
        return dist[N];
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        System.out.println(dijkstra(1));
	}
}