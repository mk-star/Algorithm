import java.util.*;
import java.io.*;
public class Main {
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int[] op;
	static int[] number;
	static int N;
 
    public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;

				switch (i) {
                    case 0: dfs(num + number[idx], idx + 1);
                        break;
                    case 1: dfs(num - number[idx], idx + 1);
                        break;
				    case 2: dfs(num * number[idx], idx + 1);
                        break;
				    case 3: dfs(num / number[idx], idx + 1); 
                        break;
				}
				op[i]++;
			}
		}
	}
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
 
        st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
 
		dfs(number[0], 1);
 
		System.out.println(MAX);
		System.out.println(MIN);
    }
}