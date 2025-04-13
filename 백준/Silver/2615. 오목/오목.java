import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    // 순서대로 오른쪽, 아래, 위대각선, 아래대각선
    static int[] dx = {0, 1, -1, 1};
    static int[] dy = {1, 0, 1, 1};

    static boolean solution(int i, int j) {
        int[] cnt = {1, 1, 1, 1};
        
        for(int t = 0; t < 4; t++) {
            int x = i + dx[t];
            int y = j + dy[t]; 

            while(true) {
                if(x >= 0 && x < 19 && y >= 0 && y < 19) {
                    if(board[i][j] == board[x][y]) {
                        cnt[t]++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
                x += dx[t];
                y += dy[t]; 
            }
        }

        for(int t = 0; t < 4; t++) {
            int x = i - dx[t];
            int y = j - dy[t]; 

            while(true) {
                if(x >= 0 && x < 19 && y >= 0 && y < 19) {
                    if(board[i][j] == board[x][y]) {
                        cnt[t]++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
                x -= dx[t];
                y -= dy[t]; 
            }

            if(cnt[t] == 5) {
                if(t == 2) {
                    System.out.println(board[i][j]);
                    System.out.println(x + " " + (y + 2));
                } else {
                    System.out.println(board[i][j]);
                    System.out.println((i + 1) + " " + (j + 1));
                }
                return true;
            }
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
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
