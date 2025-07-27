import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    static int s1, s2;

    static void binarySearch(int left, int right, int idx) {
        while(left <= right) {
            int mid = (left + right) / 2;

            int diff = arr[mid] + arr[idx];

            if(Math.abs(diff) < min) {
                s1 = mid;
                s2 = idx;
                min = Math.abs(diff);
            }

            if(diff < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 1; i < N; i++) {
            binarySearch(0, i - 1, i);
        }

        System.out.println(s1 < s2 ? arr[s1] + " " + arr[s2] : arr[s2] + " " + arr[s1]);
    }
}