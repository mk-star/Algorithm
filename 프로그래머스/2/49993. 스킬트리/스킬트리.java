class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
        
        for(int t = 0; t < skill_trees.length; t++) {
            int len = skill.length();
            String s = skill_trees[t]; 
            int[] num = new int[len + 1]; 
            for(int i = 0; i < len; i++) { 
                num[i] = s.length();
                for(int j = 0; j < s.length(); j++) {
                    if(skill.charAt(i) == s.charAt(j)) {
                        num[i] = j;
                        break;
                    }
                }
            }
            
            for(int i = 1; i < len; i++) {
                if(num[i] < num[i - 1]) break;
                if(i == len - 1) {
                    answer = answer == -1 ? 1 : answer + 1;
                }
            }
            if(len == 1) answer = skill_trees.length;
        }
        if(answer == -1) return 0;
        else return answer;
    }
}