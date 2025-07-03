import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<String> word;

	static void sortWord(String s) {
		int idx = word.size();

		for(int i = 0; i < word.size(); i++) {
			if(s.length() < word.get(i).length()) {
				idx = i;
				break;
			}

			if(s.length() == word.get(i).length()) {
				if(s.compareTo(word.get(i)) < 0) {
					idx = i;
					break;
				}
			}	
		}
		word.add(idx, s);
	}
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		word = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			if(word.contains(s)) continue;
			sortWord(s);
		}

		for(int i = 0; i < word.size(); i++) {
			System.out.println(word.get(i));
		}
    }
}