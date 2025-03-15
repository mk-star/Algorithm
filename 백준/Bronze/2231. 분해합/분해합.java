import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int N = Integer.parseInt(br.readLine());

        int i = 1;
        int result = 0;
        while(i < N) {
            int sum = i;
            int temp = i;
            while(temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if(sum == N) {
                result = i;
                break;
            }
            i++;
        }
        System.out.println(result);
    }
}
