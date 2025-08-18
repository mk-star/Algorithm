import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] ground = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = Integer.MAX_VALUE;
		int height = 0;
		for(int h = 0; h <= 256; h++) {
			int b = B;
			int time = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(ground[i][j] > h) {
						b += ground[i][j] - h;
						time += 2 * (ground[i][j] - h);
					} else if(ground[i][j] < h) {
						b -= h - ground[i][j];
						time += h - ground[i][j];
					}
				}
			}

			if(b < 0) continue;
			if(time <= min) {
				min = time;
				height = h;
			}
		}
		System.out.println(min + " " + height);
	}
}