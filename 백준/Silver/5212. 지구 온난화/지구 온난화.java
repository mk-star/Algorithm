import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] arr = new char[R][C];
        char[][] temp = new char[R][C];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
                temp[i][j] = s.charAt(j);
            }
        }

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] == 'X') {
                    int cnt = 0;
                    for(int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if(x >= 0 && y >= 0 && x < R && y < C) {
                            if(arr[x][y] == '.') cnt++;
                        } else cnt++;
                    }
                    if(cnt >= 3) temp[i][j] = '.';
                }
            }
        }

        int minX = R, minY = C;
        int maxX = 0, maxY = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(temp[i][j] == 'X') {
                    minX = Math.min(minX, i); 
                    minY = Math.min(minY, j); 
                    maxX = Math.max(maxX, i); 
                    maxY = Math.max(maxY, j); 
                }
            }
        }

        for(int i = minX; i <= maxX; i++) {
            for(int j = minY; j <= maxY; j++) {
                System.out.print(temp[i][j]);
            }
            System.out.println();
        }
    }
}
