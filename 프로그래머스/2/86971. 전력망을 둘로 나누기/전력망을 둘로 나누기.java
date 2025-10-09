import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int n;
    
    public static int dfs(int start) {
        visited[start] = true;
        
        int cnt = 1;
        for(int cur : graph.get(start)) {
            if(!visited[cur]) {
                visited[cur] = true;
                cnt += dfs(cur);
            }
        }
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++) {
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            visited = new boolean[n + 1];
            
            // v1에 v2 인덱스가 아닌 v2 값으로 제거해야 됨
            // (Integer)로 캐스팅
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));
            
            int cnt = dfs(1);
            // 전력망 1: n - cnt개, 전력망 2: cnt개
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(diff, min);
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        return min;
    }
}