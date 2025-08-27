import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N != 0) {
            st = new StringTokenizer(br.readLine());
        }

        int[] arr =  new int[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int rank = N + 1;
        for(int i = N; i >= 1; i--) {
            if(score < arr[i]) break;
            else if(score == arr[i]) {
                rank = i;
                if(P <= i) {
                    rank = -1;
                    break;
                }
            } else {
                rank = i;
            }
        }
        if(rank > P) rank = -1;
        System.out.println(rank);
	}
}