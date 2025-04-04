import java.io.*;
// 돌은 1개 또는 3개 가져갈 수 있음
// 상근 먼저 시작
// 상근이가 1개를 가져가면 - 창영이는 1개 또는 3개
// 상근이가 3개를 가져가면 창영이는 1개
public class Main {
    static void solution(int N, int p) {
        if(N < 0) return;
        if(N == 0) {
            if(p == 0) System.out.println("SK");
            else System.out.println("CY");
            System.exit(0);
        }
        p = p == 0 ? 1 : 0;

        solution(N - 1, p); // 1개를
        solution(N - 3, p); // 3개를 

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        solution(N, 1);
    }
}