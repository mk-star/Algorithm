import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> list;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    static int bfs(int start, int end) {
        visited[start] = true;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node e = pq.poll();
            visited[e.index] = true;

            if(e.index == end) {
                return e.cost;
            }

            for(Node n : list.get(e.index)) {
                if(!visited[n.index]) {
                    pq.offer(new Node(n.index, e.cost + n.cost));
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(bfs(start, end));
    }
}