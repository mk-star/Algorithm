import java.io.*;
public class Main {
    static boolean isAp(int n) {
        int diff = 0;
        for(int i = 0; n / 10 != 0; i++) {
            int n1 = n % 10;
            int n2 = (n / 10) % 10;
            if(i != 0 && n1 - n2 != diff) return false;
            diff = n1 - n2;
            n /= 10;
        }
        return true;
    }

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

        // 1~99까지 다 됨
        // 123 111 135 159 147 210

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(isAp(i)) cnt++;
        }
        System.out.println(cnt);
	}
}