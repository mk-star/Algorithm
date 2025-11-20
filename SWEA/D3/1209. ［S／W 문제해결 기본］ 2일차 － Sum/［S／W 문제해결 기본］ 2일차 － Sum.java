import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++) {

            int T = Integer.parseInt(br.readLine());

            int[][] arr = new int[100][100];

            for(int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int sum = 0;
                for(int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    sum += arr[i][j];
                }
            }

            int max = Integer.MIN_VALUE;
            // 가로
            for(int i = 0; i < 100; i++) {
                int sum = 0;
                for(int j = 0; j < 100; j++) {
                    sum += arr[i][j];
                }
                max = Math.max(sum, max);
            }

            // 세로
            for(int i = 0; i < 100; i++) {
                int sum = 0;
                for(int j = 0; j < 100; j++) {
                    sum += arr[j][i];
                }
                max = Math.max(sum, max);
            }

            // 아래 대각선
            int sum = 0;
            for(int i = 0; i < 100; i++) {
                sum += arr[i][i];
            }
            max = Math.max(sum, max);

            // 위 대각선
            sum = 0;
            for(int i = 0; i < 100; i++) {
                sum += arr[i][100 - i - 1];
            }
            max = Math.max(sum, max);

            sb.append('#').append(T).append(' ').append(max).append('\n');
		}

        System.out.println(sb);
	}
}