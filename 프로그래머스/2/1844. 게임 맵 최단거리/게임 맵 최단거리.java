import java.util.*;

class Solution {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;
    
    static int bfs(int startX, int startY, int[][] maps, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startX, startY, 1 });
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if(cur[0] == n - 1 && cur[1] == m - 1) return cur[2];
            
            for(int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                int cnt = cur[2];
                
                if(x >= 0 && y >= 0 && x < n && y < m) {
                    if(!visited[x][y] && maps[x][y] != 0) {
                        queue.offer(new int[] { x, y, cnt + 1 });
                        visited[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {   
        visited = new boolean[maps.length][maps[0].length];
        
        return bfs(0, 0, maps, maps.length, maps[0].length);
    }
}