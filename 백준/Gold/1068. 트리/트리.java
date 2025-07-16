import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int R;
    static int cnt = 0;

    static void dfs(int start) {
        if(start == R) return;

        for(int v : graph.get(start)) {
            if(v != R) { // 자식 노드가 지울 노드가 아닐 때
                if(graph.get(v).size() == 0) cnt++; // 자식 노드가 리프 노드라면 cnt++;
                else dfs(v);
            } else { // 자식 노드가 지울 노드라면
                if(graph.get(start).size() == 1) cnt++; // 부모 노드의 자식이 지울 노드밖에 없다면
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int start = 0;
        for(int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            if(v == -1) {
                start = i;
                continue;
            }
            else graph.get(v).add(i);  
        }

        R = Integer.parseInt(br.readLine());

        dfs(start);
        System.out.println(cnt);
    }
}
