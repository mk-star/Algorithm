import java.util.*;

class Solution {
    static boolean[] visited;
    static int[] arr;
    static Set<Integer> set;

    static boolean isPrime(int num) {
        if(num < 2) return false;
        
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    static void dfs(int depth, int num, int len) {
        if(depth == len) {
            set.add(num);
            return;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true; 
                dfs(depth + 1, num * 10 + arr[i], len);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        int len = numbers.length();
        arr = new int[len];
        visited = new boolean[len];
        set = new HashSet<>();
        
        for(int i = 0; i < len; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }
        
        for(int i = 1; i <= len; i++) {
            dfs(0, 0, i);
        }
        
        int cnt = 0;
        for(int num : set) {
            if(isPrime(num)) cnt++;
        }
        
        return cnt;
    }
}
