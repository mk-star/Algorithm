class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
			String[] s = skill_trees[i].split("");
			int index = 0;
            
			for (int j = 0; j < s.length; j++) {
				if (index < skill.indexOf(s[j])) {
					break;
				} else if (index == skill.indexOf(s[j])) {
					index++;
				}
                if (j == s.length - 1) answer++;
			}
		}
		return answer;
    }
}