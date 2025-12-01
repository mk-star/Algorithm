import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<Integer> set;

    static boolean isPrime(int num) {
        if(num < 2) return false;
        
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    static void permutation(int depth, int r, int num, String numbers) {
        if(depth == r) {
            set.add(num);
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true; 
                permutation(depth + 1, r, num * 10 + (numbers.charAt(i) - '0'), numbers);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        
        for(int i = 1; i <= numbers.length(); i++) {
            permutation(0, i, 0, numbers);
        }
        
        int cnt = 0;
        for(int num : set) {
            if(isPrime(num)) cnt++;
        }
        
        return cnt;
    }
}
