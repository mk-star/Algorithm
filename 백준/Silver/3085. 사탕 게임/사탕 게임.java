import java.io.*;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static char[][] candy;

    static void getLongestPart() {
        // 행
        for(int i = 0; i < N; i++) {
            int cnt = 0;
            char c = candy[i][0];
            for(int j = 0; j < N; j++) {
                if(c != candy[i][j]) {
                    max = Math.max(max, cnt);
                    c = candy[i][j];
                    cnt = 1;
                } else cnt++;
            }
            max = Math.max(max, cnt);
        }

        // 열
        for(int i = 0; i < N; i++) {
            int cnt = 0;
            char c = candy[0][i];
            for(int j = 0; j < N; j++) {
                if(c != candy[j][i]) {
                    max = Math.max(max, cnt);
                    c = candy[j][i];
                    cnt = 1;
                } else cnt++;
            }
            max = Math.max(max, cnt);
        }
    }

    static void swap(int i, int j, int x, int y) {
        char temp = candy[i][j];
        candy[i][j] = candy[x][y];
        candy[x][y] = temp;
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        candy = new char[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                candy[i][j] = str.charAt(j);
            }
        }

        int[] dx = { 1, 0 };
        int[] dy = { 0, 1 };
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int t = 0; t < 2; t++) {
                    int x = i + dx[t];
                    int y = j + dy[t];

                    if(x < N && y < N) {
                        if(candy[i][j] != candy[x][y]) {
                            swap(i, j, x, y);
                            getLongestPart();
                            swap(i, j, x, y);
                        }

                    }
                }
            }
        }

        System.out.println(max);
	}
}