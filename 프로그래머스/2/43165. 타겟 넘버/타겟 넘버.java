class Solution {
    static int answer;
    static int[] op = { 1, -1 };
    
    static void dfs(int depth, int r, int sum, int[] numbers, int target) {
        if(depth == r) {
            if(sum == target) answer++;
            return;
        }
        
        for(int i = 0; i < 2; i++) {
            dfs(depth + 1, r, sum + op[i] * numbers[depth], numbers, target);
        }
    }
    
    public int solution(int[] numbers, int target) { 
        dfs(0, numbers.length, 0, numbers, target);
        return answer;
    }
}