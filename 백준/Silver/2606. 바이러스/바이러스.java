import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static int cnt = 0;

	static void dfs(int num) {
		visited[num] = true;
		
		for(int i = 2; i < arr.length; i++) {
			if(!visited[i] && arr[num][i] == 1) {
				cnt++;
				visited[i] = true;
				dfs(i);
			}
		}
	}
    
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		arr = new int[num + 1][num + 1];
		visited = new boolean[num + 1];

		int pair = Integer.parseInt(br.readLine());
		for(int i = 0; i < pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		dfs(1);
		System.out.println(cnt);
	}
}
