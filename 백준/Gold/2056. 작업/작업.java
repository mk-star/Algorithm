import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        int max = 0;
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            dp[i] = time;
            for(int j = 0; j < num; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                dp[i] = Math.max(dp[i], dp[tmp] + time);
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
