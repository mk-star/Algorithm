import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] A, X;

    static int binarySearch(int num) {
        int left = 0;
        int right = N - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(A[mid] == num) return 1;
            else if(A[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        X = new int[M];
        for(int i = 0; i < M; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for(int i = 0; i < M; i++) {
            System.out.println(binarySearch(X[i]));
        }
	}
}