import java.io.*;
//.이 없는 경우 -> AAAA가 되는 경우/ AAAA+BB가 되는 경우/BB만 되는 경우
// .이 있는 경우
// 마지막....은 보통 .으로 안 끝남.
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i < board.length(); i++) {
            if(board.charAt(i) == 'X') cnt++;
            if(board.charAt(i) == '.' || i == board.length() - 1) {
                if(cnt % 4 == 0) for(int j = 0; j < cnt / 4; j++) sb.append("AAAA");
                else if(cnt % 4 == 2) {
                    for(int j = 0; j < cnt / 4; j++) sb.append("AAAA");
                    sb.append("BB");
                } else {
                    break;
                }
                cnt = 0;
                if(board.charAt(i) == '.') sb.append(".");
            }
        }

        if(cnt == 0) System.out.println(sb);
        else System.out.println(-1);
    }
}
