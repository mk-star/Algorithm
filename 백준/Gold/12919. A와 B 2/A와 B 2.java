import java.io.*;
// S -> T가 아닌 T -> S로 만듦
public class Main {
    static int result;

    static void solution(String S, String T) {
        if(S.equals(T)) {
            result = 1;
            return;
        }

        if(S.length() >= T.length()) {
            return;
        }

        if(T.charAt(T.length() - 1) == 'A') {
            String t = T.substring(0, T.length() - 1);
            solution(S, t);
        } 

        if(T.charAt(0) == 'B') {
            String t = T.substring(1, T.length());
            StringBuilder sb = new StringBuilder(t);
            sb.reverse();
            t = sb.toString();
            solution(S, t);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        String T = br.readLine();

        result = 0;
        solution(S, T);
        System.out.println(result);
    }
}
