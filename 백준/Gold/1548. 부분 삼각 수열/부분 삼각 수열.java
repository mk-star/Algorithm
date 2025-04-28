import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int max = 1;
        for(int i = 0; i < N - 1; i++) {
            int cnt = 0;
            for(int j = i + 2; j < N; j++) {
                if(A[i] + A[i + 1] > A[j]) {
                    cnt++;
                }
            }
            max = Math.max(cnt + 2, max);
        }
        System.out.println(max);
    }
}