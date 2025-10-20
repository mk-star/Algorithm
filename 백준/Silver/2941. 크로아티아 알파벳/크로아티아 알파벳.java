import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] croAlpha = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

        String str = br.readLine();
        
        StringBuilder sb = new StringBuilder(str);

        int croAlphaCnt = 0;
        int replaceCnt = 0;
        for(String s : croAlpha) {
            while(sb.toString().contains(s)) {
                int index = sb.indexOf(s);
        
                for(int i = index; i < index + s.length(); i++) {
                    sb.setCharAt(i, '.');
                    replaceCnt++;
                }
                croAlphaCnt++;
            }
        }
        System.out.println(croAlphaCnt + sb.length() - replaceCnt);
	}
}