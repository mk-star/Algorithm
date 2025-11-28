import java.util.*;

class Solution {
    static boolean[] visited;
    static int[] arr;
    static int cnt = 0;
    static Queue<Integer> queue = new LinkedList<>();
    
    static boolean isPrime(int num) {
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    static void dfs(int depth) {
        if(depth >= 1) {
            int num = 0;
            while(!queue.isEmpty()) {
                num *= 10;
                num += queue.poll();
            }
            System.out.println(num);
            if(isPrime(num)) cnt++;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                queue.offer(arr[i]);
                dfs(depth + 1);
                visited[i] = false;
            }    
        }
    }
    
    public int solution(String numbers) {
        arr = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i) - '0';
        }
        
        dfs(0);
        
        return cnt;
    }
}
