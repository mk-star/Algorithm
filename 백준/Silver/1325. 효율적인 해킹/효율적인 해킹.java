import java.io.*;
import java.util.*;
// A가 B를 신뢰 = B를 해킹하면 A도 해킹 가능
// 1을 해킹하면 3도 가능
// 2를 해킹하면 3
// 3을 해킹하면 4, 5도 가능
public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    static int bfs(int v) {
        int cnt = 1;
        visited[v] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while(!q.isEmpty()) {
            int x = q.poll();

            for(int num : graph.get(x)) {
                if(!visited[num]) {
                    q.offer(num);
                    visited[num] = true;
                }
            }
            cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            graph.get(B).add(A);
        }

        int max = Integer.MIN_VALUE;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            int cnt = bfs(i);
            if(max == cnt) {
                arr.add(i);
            }
            if(max < cnt) {
                arr.clear();
                arr.add(i);
                max = cnt;
            }
            visited = new boolean[N + 1];
        }
        Collections.sort(arr);
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}