import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;

   static boolean solution(int i, int j) {
        // 오른쪽
        int x = i;
        int y = j + 1;
        int cnt = 1;
        while(y < 19) {
            if(board[x][y] == board[i][j]) {
                cnt++;
            } else {
                break;
            }
            y += 1;
        }

        // 왼쪽
        x = i;
        y = j - 1;
        while(y >= 0) {
            if(board[x][y] == board[i][j]) {
                cnt++;
            } else {
                break;
            }
            y -= 1;
        }

        if(cnt == 5) {
            System.out.println(board[i][j]);
            System.out.println((x + 1) + " " + (y + 2));
            return true;
        }

        // 아래
        x = i + 1;
        y = j;
        cnt = 1;
        while(x < 19) {
            if(board[x][y] == board[i][j]) {
                cnt++;
            } else {
                break;
            }
            x += 1;
        }

        // 위
        x = i - 1;
        y = j;
        while(x >= 0) {
            if(board[x][y] == board[i][j]) {
                cnt++;
            } else {
                break;
            }
            x -= 1;
        }

        if(cnt == 5) {
            System.out.println(board[i][j]);
            System.out.println((x + 2) + " " + (y + 1));
            return true;
        }

        // 위 대각선(위)
        x = i - 1;
        y = j + 1;
        cnt = 1;
        while(x >= 0 && y < 19) {
            if(board[x][y] == board[i][j]) {
                cnt++;
            } else {
                break;
            }
            x -= 1;
            y += 1;
        }

        // 위 대각선(아래)
        x = i + 1;
        y = j - 1;
        while(x < 19 && y >= 0) {
            if(board[x][y] == board[i][j]) {
                cnt++;
            } else {
                break;
            }
            x += 1;
            y -= 1;
        }

        if(cnt == 5) {
            System.out.println(board[i][j]);
            System.out.println(x + " " + (y + 2));
            return true;
        }

        // 아래 대각선(아래)
        x = i + 1;
        y = j + 1;
        cnt = 1;
        while(x < 19 && y < 19) {
            if(board[x][y] == board[i][j]) {
                cnt++;
            } else {
                break;
            }
            x += 1;
            y += 1;
        }

        // 아래 대각선(위)
        x = i - 1;
        y = j - 1;
        while(x >= 0 && y >= 0) {
            if(board[x][y] == board[i][j]) {
                cnt++;
            } else {
                break;
            }
            x -= 1;
            y -= 1;
        }

        if(cnt == 5) {
            System.out.println(board[i][j]);
            System.out.println((x + 2) + " " + (y + 2));
            return true;
        }
        return false;
   }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        board = new int[19][19];
        for(int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                if(board[i][j] != 0) {
                    if (solution(i, j)) {
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(0);
    }
}
