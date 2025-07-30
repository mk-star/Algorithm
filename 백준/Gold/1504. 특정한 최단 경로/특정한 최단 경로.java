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
    public int compareTo(Node n) {
        return this.weight - n.weight;
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static int INF = 200000000;

    static void bfs(int start) {
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
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
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[N + 1];

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
            
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        // 1 -> v1 -> v2 -> N
        bfs(v1); //v1에서 시작
        long v1_1 = dist[1];     // v1 → 1
        long v1_v2 = dist[v2];   // v1 → v2
        long v1_N = dist[N];     // v1 → n

        // 1 -> v2 -> v1 -> N
        bfs(v2); // v2에서 시작
        long v2_1 = dist[1];     // v2 → 1
        long v2_N = dist[N];     // v2 → n

        long r1 = v1_1 + v1_v2 + v2_N;
        long r2 = v2_1 + v1_v2 + v1_N;

        long result = r1 < r2 ? r1 : r2;
        
        if(result >= INF) result = -1;
        System.out.println(result);
    }
}