import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static String[] arr;

	static boolean isValidPassword(String password) {
		String vowel = "aeiou";
		int vowelCount = 0;
		int consonantCount = 0;

		for(String s : password.split("")) {
			if(vowel.contains(s)) {
				vowelCount++;
			} else {
				consonantCount++;
			}
		}

		return vowelCount >= 1 && consonantCount >= 2;
	}

	static void solution(int n, int count, String password) {
		if(count == L) {
			if(isValidPassword(password)) {
				System.out.println(password);
			}
			return;
		}
		
		for(int i = n; i < C; i++) {
			solution(i + 1, count + 1, password + arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new String[C];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			arr[i] = st.nextToken();
		}
		
		Arrays.sort(arr);

		solution(0, 0, "");
    }
}