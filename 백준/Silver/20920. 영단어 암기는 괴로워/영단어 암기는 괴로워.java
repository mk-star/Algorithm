import java.io.*;
import java.util.*;
// 빈도수 -> 길이 -> 사전순
// M 이상인 단어만

class Word implements Comparable<Word> {
    String s; // 단어
    int cnt; // 빈도수
    int len; // 길이

    Word(String s, int cnt, int len) {
        this.s = s;
        this.cnt = cnt;
        this.len = len;
    }

    @Override
    public int compareTo(Word o) {
        if(this.cnt != o.cnt) return o.cnt - this.cnt;       // 빈도수 내림차순
        if(this.len != o.len) return o.len - this.len;       // 길이 내림차순
        return this.s.compareTo(o.s);           
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Word> pq = new PriorityQueue<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.length() < M) continue;

            if(map.containsKey(str)) map.put(str, map.get(str) + 1);  
            else map.put(str, 1);
        }

        for(String key : map.keySet()) {
            pq.offer(new Word(key, map.get(key), key.length()));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll().s).append("\n");
        }
        System.out.println(sb);
	}
}
