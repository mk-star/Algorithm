import java.io.*;
import java.util.*;
public class Main { 
    static int cnt = 0;
    
    static void find(int size, int r, int c) {
		if(size == 1)
			return;
		
		if(r < size / 2 && c < size / 2) { // 1사분면
			find(size / 2, r, c);
		} else if(r < size / 2 && c >= size / 2) { // 2사분면
			cnt += size * size / 4; // 1사분면 지나고
			find(size / 2, r, c - size / 2);
		} else if(r >= size / 2 && c < size / 2) { // 3사분면
			cnt += (size * size / 4) * 2; // 2사분면 지나고
			find(size / 2, r - size / 2, c);
		} else { // 4사분면
			cnt += (size * size / 4) * 3; // 3사분면 지나고
			find(size / 2, r - size / 2, c - size / 2);
		}
	}
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        find((int) Math.pow(2, N), r, c);

        System.out.println(cnt);
    }
}