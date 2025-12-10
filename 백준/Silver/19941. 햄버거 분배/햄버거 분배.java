import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        boolean[] visited = new boolean[N];
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            if(str.charAt(i) == 'P') {
                int startIndex = Math.max(i - K, 0);
                int endIndex = Math.min(i + K, N - 1);

                for(int j = startIndex; j <= endIndex; j++) {
                    if(!visited[j] && str.charAt(j) == 'H') {
                        cnt++;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
	}
}