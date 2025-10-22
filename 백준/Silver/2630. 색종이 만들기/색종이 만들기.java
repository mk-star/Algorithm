import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int N;
    static int whiteCnt, blueCnt;

    static void partition(int x, int y, int size) {
        if(checkColor(x, y, size)) {
            if(arr[x][y] == 0) whiteCnt++;
            else blueCnt++;
            return;
        }

        int newSize = size / 2;

        partition(x, y, newSize); // 제 1사분면
        partition(x, y + newSize, newSize); // 제 2사분면
        partition(x + newSize, y, newSize); // 제 3사분면
        partition(x + newSize, y + newSize, newSize); // 제 4사분면
    }

    static boolean checkColor(int x, int y, int size) {
        int color = arr[x][y];
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(color != arr[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);
	}
}
