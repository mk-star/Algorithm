import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    static void solution(int idx, int cnt) {
        if(cnt == N / 2) {
            int start = 0; 
            int link = 0;
            for(int i = 1; i <= N; i++) {
                for(int j = i + 1; j <= N; j++) {
                    if(visited[i] && visited[j]) {
                        start += S[i][j] + S[j][i];
                    }
                    if(!visited[i] && !visited[j]) {
                        link += S[i][j] + S[j][i];
                    }
                }
            }
            min = Math.min(Math.abs(start - link), min);
            return;
        }

        for(int i = idx + 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                solution(i, cnt + 1);
                visited[i] = false;
            }
        }
    }

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		S = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(1, 0);
		System.out.println(min);
	}
}