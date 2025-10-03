import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {      
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < participant.length; i++) {
            String p = participant[i];
            if(map.containsKey(p)) map.put(p, map.get(p) + 1);
            else map.put(p, 1);
        }
        
        for(int i = 0; i < completion.length; i++) {
            String c = completion[i];
            if(map.get(c) > 1) map.put(c, map.get(c) - 1);
            else map.remove(c);
        }
        
        for(String key : map.keySet()) {
            return key;
        }
        return null;
    }
}