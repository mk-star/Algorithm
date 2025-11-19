import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++) {

            int T = Integer.parseInt(br.readLine());

            int[][] arr = new int[100][100];
            
            int x = 0, y = 0;
            for(int i = 0; i < 100; i++) {
                String[] s = br.readLine().split(" ");
                for(int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                    if(arr[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }
            }

            while(x > 0) {
                if(y + 1 < 100 && arr[x][y + 1] == 1) {
                    while(y + 1 < 100 && arr[x][y + 1] == 1) { 
                        //오른족
                        y++; 
                    } 
                } else if(y - 1 >= 0 && arr[x][y - 1] == 1) {
                    while(y - 1 >= 0 && arr[x][y - 1] == 1) {
                        // 왼쪽
                        y--;
                    }
                }
                x--;
            }
            sb.append('#').append(T).append(' ').append(y).append('\n');
		}

        System.out.println(sb);
	}
}