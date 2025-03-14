import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer num = 666;
        int cnt = 0;
        while(true) {
            if(num.toString().contains("666")) cnt++;
            
            if(cnt == N) {
                System.out.println(num);
                break;
            }
            num++;
        }
    }
}