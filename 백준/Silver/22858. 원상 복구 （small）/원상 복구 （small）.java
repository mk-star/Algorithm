import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] P = new int[N + 1];
        int[] T = new int[N + 1];
        int[] D = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            D[Integer.parseInt(st.nextToken())] = i;
        }

        for(int t = 0; t < K; t++) {
            for(int i = 1; i <= N; i++) {
                T[i] = P[D[i]];
            }
            for(int i = 1; i <= N; i++) {
                P[i] = T[i];
            }
        }

        for(int i = 1; i <= N; i++) {
            System.out.print(P[i] + " ");
        }
    }
}