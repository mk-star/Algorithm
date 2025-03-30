import java.io.*;
import java.util.*;
// 확장자 별로 정리, 같은 몇개인지
// 확장자를 사전 순으로 정렬
public class Main {
    static void dd() {
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String s = br.readLine().split("\\.")[1];
            if(map.containsKey(s)) { 
                int cnt = map.get(s) + 1;
                map.replace(s, cnt);
            } else {
                map.put(s, 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        for(String s: keySet) {
            System.out.println(s + " " + map.get(s));
        }
    }
}