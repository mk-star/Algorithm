import java.io.*;

public class Main {
    static int[][] arr;
    static int N;
    static StringBuilder sb;

    static void partition(int x, int y, int size) {
        if(checkVideo(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        } else {
            sb.append("(");
        }

        int newSize = size / 2;

        partition(x, y, newSize); // 제 1사분면
        partition(x, y + newSize, newSize); // 제 2사분면
        partition(x + newSize, y, newSize); // 제 3사분면
        partition(x + newSize, y + newSize, newSize); // 제 4사분면
        sb.append(")");
    }

    static boolean checkVideo(int x, int y, int size) {
        int dot = arr[x][y];
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(dot != arr[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
    
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        partition(0, 0, N);

        System.out.println(sb);
    }
}
