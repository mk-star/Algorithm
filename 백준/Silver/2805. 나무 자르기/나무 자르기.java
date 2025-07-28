import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] prefixSum;

    static int binarySearch(int max) {
        int left = 0; int right = max;
        int result = 0;

        while(left <= right) {
            // 0 ~ 가장 큰 값의 중간값
            int mid = (left + right) / 2;

            long sum = 0;
            for(int num : arr) {
                if(num > mid) sum += num - mid;
            }

            if(sum >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int max = 0;
    
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) max = arr[i];
        }

        System.out.println(binarySearch(max));
    }
}
