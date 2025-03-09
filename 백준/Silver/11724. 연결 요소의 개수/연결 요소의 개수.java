import java.io.*;
import java.util.*;
// 무방향 그래프
// 정점의 개수: N, 간선의 개수: M
// 1 2 5
// 1 -> 2, 5
// 2 -> 5, 1
// 5 -> 1, 2
// 3 -> 4, 6
// 4 -> 3, 6
// 6 -> 3, 4
public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean visited[];

    public static void dfs(int x) {
        visited[x] = true;

        for(int u : graph.get(x)) {
            if(!visited[u]) dfs(u);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) count++;
            dfs(i);
        }
        System.out.println(count);
    }
}
