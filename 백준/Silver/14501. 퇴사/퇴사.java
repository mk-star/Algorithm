import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] arr;
    static int max = 0;

    static void solution(int i, int sum) {
        max = Math.max(sum, max);

        if(i > N) return;
   
        if(i + arr[i][0] <= N + 1) {
            solution(i + arr[i][0], sum + arr[i][1]); // i를 선택
        }
        
        solution(i + 1, sum); // i를 선택 X
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
    
        arr = new int[N + 1][2];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(1, 0);
        System.out.println(max);
    }
}
