import java.io.*;
import java.util.*;
public class Main { 
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N][3];
		int[][] house = new int[N][3];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) { // 첫 번째 -> R
                if (k == j) dp[0][j] = house[0][j]; // 첫 번째 -> R
                else dp[0][j] = 1001; // 나머지는 색칠 불가능
            }

			for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][0]; // R을 선택, 이전에 G or B의 최솟값 + 현재
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][1]; // G를 선택, 이전에 R or B의 최솟값 + 현재
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + house[i][2]; // B를 선택, 이전에 R or G의 최솟값 + 현재
			}   
			
			for (int i = 0; i < 3; i++) {   // 마지막 집은 첫 집이랑 달라야함
				if(i != k) min = Math.min(min, dp[N - 1][i]);
			}
		}
		System.out.println(min);
	}
}