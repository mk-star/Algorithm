import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

    static void binarySearch(int start) {
        int left = 0;
        int right = N - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

           if(arr[start] + M <= arr[mid]) {
                min = Math.min(min, arr[mid] - arr[start]);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            binarySearch(i);
        }
        
        System.out.println(min);
    }
}