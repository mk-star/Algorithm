import java.io.*;
// Fn = Fn-1 + Fn-2
public class Main {
    static int fibo(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fibo(n - 1) + fibo(n - 2);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(fibo(n));
    }
}
