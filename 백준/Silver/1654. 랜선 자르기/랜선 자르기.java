import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
    static int cnt = 0;

	static long binarySearch(long max) {
        long left = 1; long right = max;
        long result = 0;

		while(left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for(int i = 0; i < K; i++) {
                sum += arr[i] / mid;
            }

            if(sum >= N) {
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
        K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[K];
        long max = Integer.MIN_VALUE;

        for(int i = 0; i < K; i++) {
           arr[i] = Integer.parseInt(br.readLine());
           max = Math.max(arr[i], max);
        }

		System.out.println(binarySearch(max));
	}
}