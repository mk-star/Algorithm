import java.io.*;
import java.util.*;
public class Main {
    static int getStrikeCount(int n1, int n2) {
        int strike = 0;
        while(n1 != 0) {
            if(n1 % 10 == n2 % 10) strike++;
            n1 /= 10;
            n2 /= 10;
        }
        return strike;
    }

    static int getBallCount(int n1, int n2) {
        int cnt = 0;
        for(int i = 0 ; i < 3; i++) {
            int temp = n2;
            for(int j = 0; j < 3; j++) {
                if(n1 % 10 == temp % 10) cnt++;
                temp /= 10;
            }
            n1 /= 10;
        }
        return cnt;
    }

    static boolean validateNum(int num) {
        int digit1 = num / 100;
        int digit2 = (num / 10) % 10;
        int digit3 = num % 10;

        return digit1 != 0 && digit2 != 0 && digit3 != 0 && digit1 != digit2 && digit2 != digit3 && digit1 != digit3;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 123;
        int cnt = 0;
        while(num < 1000) {
            int i;
            for(i = 0; i < N; i++) {
                int strike = getStrikeCount(arr[i][0], num);
                int ball = getBallCount(arr[i][0], num) - strike;
                if(strike != arr[i][1]) break;
                if(ball != arr[i][2]) break;
            }
            if(i == N && validateNum(num)) cnt++;
            num++;
        }
        System.out.println(cnt);
    }
}
