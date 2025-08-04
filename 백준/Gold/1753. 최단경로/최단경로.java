import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int index;
    int weight;

    Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
        
            for(Node n : graph.get(cur.index)) {
                if(dist[n.index] > dist[cur.index] + n.weight) {
                    dist[n.index] = dist[cur.index] + n.weight;
                    pq.offer(new Node(n.index, dist[n.index]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(new Node(v, w));
        }

        dijkstra(K);

        for(int i = 1; i <= V; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }      
    }
}