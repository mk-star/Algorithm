import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int len = str.length();
        boolean[] visited = new boolean[len];
        char[] sound = { 'q', 'u', 'a', 'c', 'k' };

        if (len % 5 != 0 || sound[0] != 'q') {
            System.out.println(-1); 
            return;
        }
        
        int idx = 0;
        int result = 0;
        for(int i = 0; i < len; i++) {
            if(visited[i]) continue;

            List<Character> list = new ArrayList<>();
            for(int j = i; j < len; j++) {
                if(!visited[j] && sound[idx] == str.charAt(j)) {
                    list.add(sound[idx]);
                    idx = (idx + 1) % 5;
                    visited[j] = true;
                }
            }

            if(list.size() != 0 && list.size() % 5 == 0) {
                result++;
            } else {
                result = -1;
                break;
            }
        }
        
        System.out.println(result);
    }
}
