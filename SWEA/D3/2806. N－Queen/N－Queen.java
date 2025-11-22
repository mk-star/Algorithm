import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int N;
	static int[] arr;
	static int cnt;
	
	static void dfs(int depth) {
		if (depth == N) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			// i번째 열에 퀸을 배치 
			arr[depth] = i;
			if(isPossible(depth)) {
				dfs(depth + 1);
			}
		}
	}
	
	static boolean isPossible(int col) {
		for (int i = 0; i < col; i++) {
			// 같은 열인 경우
			if (arr[col] == arr[i]) {
				return false;
			} 
			
			// 같은 대각선 상에 있는 경우
			// 열의 차 = 행의 차
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N]; // 각 행의 하나의 퀸만 가능
			cnt = 0;
            
			dfs(0);

			sb.append('#').append(test_case).append(' ').append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}
}
