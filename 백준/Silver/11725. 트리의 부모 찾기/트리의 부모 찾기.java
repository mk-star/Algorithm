import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tree;
    static ArrayList<ArrayList<Integer>> result;

    static void dfs(int i, int p) {
        visited[i] = true;
        result.get(i).add(p);

        for(int v : tree.get(i)) {
            if(!visited[v]) {
                dfs(v, i);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        tree = new ArrayList<>();
        result = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            tree.add(new ArrayList<Integer>());
            result.add(new ArrayList<Integer>());
        }
        
        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            tree.get(v1).add(v2);
            tree.get(v2).add(v1);
        }
        dfs(1, 0);

        for(int i = 2; i <= N; i++) {
            System.out.println(result.get(i).get(0));
        }
    }
}
