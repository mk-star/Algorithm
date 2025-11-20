import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++) {

            int T = Integer.parseInt(br.readLine());

            int N = 100;
            // 0~99 -> 행의 합
            // 100~199 -> 열의 합
            // 200 -> 아래 대각선의 합
            // 201 -> 위 대각선의 합
            int[] sum = new int[N * 2 + 2];

            for(int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) {
                    int num = Integer.parseInt(st.nextToken());
            
                    // 행의 합
                    sum[i] += num;

                    // 열의 합
                    sum[j + N] += num;

                    // 아래 대각선의 합
                    if(i == j) sum[N * 2] += num;

                    // 위 대각선의 합
                    if(i + j == N - 1) sum[N * 2 + 1] += num;
                }
            }

            int max = Integer.MIN_VALUE;
            // 가로
            for(int s : sum) {
                max = Math.max(s, max);
            }

            sb.append('#').append(T).append(' ').append(max).append('\n');
		}

        System.out.println(sb);
	}
}