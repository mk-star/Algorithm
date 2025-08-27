import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 0) {
            if(P >= 1) System.out.println(1);
            else System.out.println(-1);
            return;
        }

        Integer[] arr =  new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> b - a);

        int rank = 1;
        for(int i = 0; i < N; i++) {
            if(score == arr[i]) {
                if(P <= i + 1) rank = -1;
                continue;
            }
            if(score > arr[i]) {
                if(P < i + 1) rank = -1;
                break;
            }
            rank++;
        }
        if(rank > P) rank = -1;
        System.out.println(rank);
	}
}