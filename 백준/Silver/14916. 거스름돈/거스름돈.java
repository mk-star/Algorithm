import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        if(n % 5 == 0) cnt += n / 5;
        if((n % 5) % 2 == 0) cnt = n / 5 + (n % 5) / 2;
        if ((n % 5 + 5) % 2 == 0) {
            if(n != 1 && n != 3) {
                cnt = (n % 5 + 5) / 2 + (n / 5 - 1);
            }
        }
        
        if(cnt != 0) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }
}
