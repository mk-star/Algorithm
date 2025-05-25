import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = n;
        for(int i = 0; i < n; i++) {
            int tempC = bfs(i, n, computers, visited);
            if(tempC != 0) count -= tempC;
        }
        return count;
    }
    
    public int bfs(int c, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        queue.offer(c);
        visited[c] = true;
        while(!queue.isEmpty()) {
            int v = queue.poll();
            for(int i = 0; i < n; i++) {
                if(v != i && computers[v][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}