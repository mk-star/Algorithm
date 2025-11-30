import java.util.*;

class Solution {
    static Stack<Integer> stack = new Stack<>();
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    
    static void dfs(int depth, int len, int k, int[][] dungeons) {
        if(depth == len) {
            int temp = k;
            int cnt = 0;
            for(int idx : stack) {
                // 최소 필요 피로도보다 k가 큰 경우, 소모 피로도를 차감
                if(temp >= dungeons[idx][0]) {
                    temp -= dungeons[idx][1];
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
            return;
        }
 
        for(int i = 0; i < len; i++) {
            if(!visited[i]) {
                visited[i] = true;
                stack.push(i);
                dfs(depth + 1, len, k, dungeons);
                stack.pop();
                visited[i] = false;
            }
        }
        
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, dungeons.length, k, dungeons);
        return max;
    }
}