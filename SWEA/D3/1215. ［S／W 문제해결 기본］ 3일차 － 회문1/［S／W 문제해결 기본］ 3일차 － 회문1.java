import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	
	static char[] word;
	static int N;
	
	static boolean isPalindrome(boolean isRow) {
		if(isRow) {
			for(int i = 0; i < N / 2; i++) {
				if(word[i] != word[N - i - 1]) {
					return false;
				}
			}
		} else {
			for(int i = 0; i < N / 2; i++) {
				if(word[i + N] != word[2 * N - i - 1]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			
			char[][] arr = new char[8][8];
			
			for(int i = 0; i < 8; i++) {
				String s = br.readLine();
				for(int j = 0; j < 8; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			int cnt = 0;
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					int xIdx = 0, yIdx = 0;
					word = new char[N * 2];
					
					for(int k = 0; k < N; k++) {
						if(j + k < 8) {
							word[xIdx++] = arr[i][j + k];
						}
						
						if(i + k < 8) {
							word[N + yIdx] = arr[i + k][j];
							yIdx++;
						}
					}
					
					if(xIdx == N) {
						if(isPalindrome(true)) {
							cnt++;
						}
					}
					
					if(yIdx == N) {
						if(isPalindrome(false)) {
							cnt++;
						}
					}
					
				}
			}
			sb.append('#').append(test_case).append(' ').append(cnt).append('\n');
			
		}
		
		System.out.println(sb);
	}
}
