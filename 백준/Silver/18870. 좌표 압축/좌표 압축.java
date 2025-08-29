import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(!map.containsKey(sortedArr[i])) {
                map.put(sortedArr[i], cnt++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");     
        }
       
       System.out.print(sb);  
	}
}