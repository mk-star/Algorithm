import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while(jimin != hansu) {
            jimin = (jimin + 1) / 2;
            hansu = (hansu + 1) / 2;

            cnt++;
        }
        System.out.println(cnt);

	}
}