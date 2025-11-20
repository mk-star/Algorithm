import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 3칸 쉬고 1칸 더하고 3칸 쉬고
        // 2칸 쉬고 3칸 더하고 2칸 쉬고
        // 1칸 쉬고 5칸 더하고 1칸 쉬고
        // 다 더하고
        // 1칸 쉬고 5칸 더하고 1칸 쉬고
        // 2칸 쉬고 3칸 더하고 2칸 쉬고
        // 3칸 쉬고 1칸 더하고 3칸 쉬고

        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for(int i = 0; i < N; i++) {
                String[] s = br.readLine().split("");
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }

            int offset = N / 2;
            int width = 1;
            int sum = 0;

            boolean isDescending = false;
            for(int i = 0; i < N; i++) {
                int skipLeft = offset; // 건너뛸 칸
                int toAdd = width; // 더할 칸

                for(int j = 0; j < N; j++) {
                    if(skipLeft > 0) {
                        skipLeft--;
                        continue;                
                    }

                    if(toAdd == 0) {
                        break;
                    }
                    sum += arr[i][j];
                    toAdd--;
                }

                // 축소 시작
                if(width == N) {
                    isDescending = true;
                }

                if(!isDescending) {
                    offset--;
                    width += 2;
                } else {
                    offset++;
                    width -= 2;
                }
            }

            sb.append('#').append(test_case).append(' ').append(sum).append('\n');
		}

        System.out.println(sb);
	}
}