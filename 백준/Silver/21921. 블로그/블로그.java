import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[X];
        int [] dp = new int[X];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < X; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        for(int i = 1; i < X; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        int max = dp[N - 1];
        int cnt = 1;
        int index = 0;
        for(int i = N; i < X; i++) {
            int temp = dp[i] - dp[index++];
            if(max < temp) {
                max = temp;
                cnt = 0;
            }
            if(max == temp) cnt++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n').append(cnt).append('\n');

        if(max == 0) System.out.println("SAD");
        else System.out.println(sb);

	}
}