import java.util.*;
import java.io.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++) {
            int[] arr = new int[100];
            
            int cnt = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < cnt; i++) {
                arr[99]--;
                arr[0]++;
                Arrays.sort(arr);
            }

            sb.append('#').append(test_case).append(' ').append(arr[99] - arr[0]).append('\n');
		}

        System.out.println(sb);
	}
}