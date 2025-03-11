import java.io.*;
import java.util.*;
// 피로도: A, 처리량: B, 피로도 감소: C, 피로도 최대: M 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int p = 0;
        int amount = 0;
        for(int i = 0; i < 24; i++) {
            if(p + A <= M) {
                p += A;
                amount += B;
            } else {
                p -= C;
                if(p < 0) p = 0;
            }
        }
        System.out.println(amount);
    }
}
