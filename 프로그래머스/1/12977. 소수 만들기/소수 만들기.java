// 더할 거니까 순서가 중요하지 않음, 중복 불가능 -> 조합
class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    static boolean isPrime(int num) {
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    static void dfs(int depth, int r, int[] nums, int index, int sum) {
        if(depth == r) {
            if(isPrime(sum)) answer++;
            return;
        }
        
        // index부터
        for(int i = index; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, r, nums, i + 1, sum + nums[i]);
                visited[i] = false;
            }
        }
        
    }
    
    public int solution(int[] nums) {
        visited = new boolean[nums.length];
        
        dfs(0, 3, nums, 0, 0);
        
        return answer;
    }
}