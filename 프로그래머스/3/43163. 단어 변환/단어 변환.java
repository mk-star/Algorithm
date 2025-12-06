import java.util.*;

class Word {
    String word;
    int cnt;
    
    Word(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }
}

class Solution {
    static boolean[] visited;
    
    static boolean checkRule(String s1, String s2, int n) {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(s1.charAt(i) == s2.charAt(i)) cnt++;
        }    
        return n - 1 == cnt;
    }
    
    static int bfs(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin, 0));
        
        while(!queue.isEmpty()) {
            Word cur = queue.poll();
            
            if(cur.word.equals(target)) return cur.cnt;
            
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && checkRule(cur.word, words[i], words[i].length())) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], cur.cnt + 1));
                }
            }
        }
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        return bfs(begin, target, words);
    }
}