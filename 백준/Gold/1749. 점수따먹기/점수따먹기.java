import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        int[][] prefixSum = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + arr[i][j];
            }
        }

        // 3 3 ~ 3 5
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) { // i =3 j = 3
                for(int x = i; x <= N; x++) { //x = 3
                    for(int y = j; y <= M; y++) { // y = 5
                        int sum = prefixSum[x][y] - prefixSum[x][j - 1] - prefixSum[i - 1][y] + prefixSum[i - 1][j - 1];
                        max = Math.max(max, sum);
                    }
                }
                
            }
        }
        System.out.println(max);
    }
}