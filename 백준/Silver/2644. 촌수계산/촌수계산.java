import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int result = -1;

    public static void dfs(int p1, int p2, int count) {
        visited[p1] = true;

        for(int y : graph.get(p1)) {
            if(p2 == y) {
                result = count + 1;
                return;
            }
            if(!visited[y]) {
                dfs(y, p2, count + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) graph.add(new ArrayList<Integer>());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(p1, p2, 0);
        System.out.println(result);
    }
}
