import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 1 3 5
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        while(right < N) {
            int diff = arr[right] - arr[left];
            
            if(M == diff) {
                min = Math.min(min, diff);
                break;
            } else if(M < diff) {
                min = Math.min(min, diff);
                left++;
            } else {
                right++;
            }
        }
        
        System.out.println(min);
    }
}