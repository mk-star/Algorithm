import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long S = Long.parseLong(br.readLine());

		int i;
		for(i = 1; i <= S; i++) {
			S -= i;
		}
		System.out.println(--i);
	}
}