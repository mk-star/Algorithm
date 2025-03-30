import java.io.*;
import java.util.*;
// 신맛 = 재료의 신맛의 곱
// 쓴맛 = 재료의 쓴맛의 합
// 신맛과 쓴맛의 차이를 작게
public class Main {
    static int min = Integer.MAX_VALUE;
    static int[][] ingre;
    static int N;

    static void solution(int i, int S, int B) {
        if(i == N) {
            if(S != 1 && B != 0) {
                min = Math.min(min, Math.abs(S - B));
            }
            return;
        }

        solution(i + 1, S * ingre[i][0], B + ingre[i][1]);
        solution(i + 1, S, B);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ingre = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            ingre[i][0] = Integer.parseInt(st.nextToken()); // 신맛
            ingre[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
        }

        solution(0, 1, 0);
        System.out.println(min);
    }
}