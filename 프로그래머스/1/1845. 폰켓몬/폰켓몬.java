import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if(map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);
        }
        
        return nums.length / 2 < map.size() ? nums.length / 2 : map.size();
    }
}