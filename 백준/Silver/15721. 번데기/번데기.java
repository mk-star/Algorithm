import java.io.*;
public class Main {
    static int A, T, call;

    static int solution() {
        int bbun = 0;
        int daegi = 0;
        int n = 2;

        while(true) {
            for(int i = 0; i < 4; i++) {
                if(i % 2 == 0) bbun++;
                else daegi++;

                if(bbun == T && call == 0) return (bbun + daegi - 1) % A;
                if(daegi == T && call == 1) return (bbun + daegi - 1) % A;
            }

            for(int i = 0; i < n; i++) {
                bbun++;
                if(bbun == T && call == 0) return (bbun + daegi - 1) % A;
            }
            for(int i = 0; i < n; i++) {
                daegi++;
                if(daegi == T && call == 1) return (bbun + daegi - 1) % A;
            }
            n++;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        call = Integer.parseInt(br.readLine());

        System.out.println(solution());
    }
}
