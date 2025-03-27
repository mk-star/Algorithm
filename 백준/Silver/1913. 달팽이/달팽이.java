import java.io.*;
public class Main {
    static int n;
    static int i, j;
    static int start, end;
    static long[][] arr;

    static void solution() {
        while(i < end - 1) {
            arr[i++][j] = n--;
        }
        arr[i][j] = n;
        while(j < end - 1) {
            arr[i][j++] = n--;
        }
        arr[i][j] = n;
        while(i > start) {
            arr[i--][j] = n--;
        }
        arr[i][j] = n;
        while(j > start) {
            arr[i][j--] = n--;
        }
        i++;
        j++;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 홀수인 자연수
        int m = Integer.parseInt(br.readLine()); // 위치를 찾고자 하는 자연수

        arr = new long[N][N];
        i = 0; j = 0; // 시작 위치
        start = 0; end = N; // i, j의 범위
        int x = 0; int y = 0; // f의 좌표
        n = N * N; // 시작값 = N * N

        while(n != 1) {
            solution();
            start++;
            end--;
        }
        arr[i][j] = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == m) {
                    x = i + 1; 
                    y = j + 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(x + " " + y);
    }
}
