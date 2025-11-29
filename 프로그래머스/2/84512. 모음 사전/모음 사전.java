import java.util.*;

class Solution {
    static String s;
    static String[] alphabet = { "A", "E", "I", "O", "U" };
    static ArrayList<String> list = new ArrayList<>();
    
    static void dfs(int depth, int len, String s) {
        if(depth == len) {
            list.add(s);
            return;
        }
         
        for(int i = 0; i < alphabet.length; i++) {
            dfs(depth + 1, len, s + alphabet[i]);
        }
    }
    
    public int solution(String word) {
        for(int i = 1; i <= alphabet.length; i++) {
            dfs(0, i, "");
        }
        
        Collections.sort(list);
        
        return list.indexOf(word) + 1;
    }
}