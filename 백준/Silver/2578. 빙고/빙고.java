import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int x, y;

    static int checkBingo() {
        int cnt = 0;

        // 가로
       for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(!visited[i][j]) break;
                if(j == 4) cnt++;
            }
        }

        // 세로
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(!visited[j][i]) break;
                if(j == 4) cnt++;
            }
        }

        // 아래 대각선
        for(int i = 0; i < 5; i++) {
            if(!visited[i][i]) break;
            if(i == 4) cnt++;
        }

        // 위 대각선
        for(int i = 0; i < 5; i++) {
            if(!visited[i][4 - i]) break;
            if(i == 4) cnt++;
        }

        if(cnt >= 3) return 1;
        return 0;

    }

    static void findNum(int num) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(num == arr[i][j]) {
                    visited[i][j] = true;
                    x = i;
                    y = j;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[5][5];
        visited = new boolean[5][5];

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());

                findNum(num);
                if(checkBingo() == 1) break;
                cnt++;
            }
        }
        System.out.println(cnt + 1);
    }
}
