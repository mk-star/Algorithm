import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String type = st.nextToken();

        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int result = set.size();
        switch(type) {
            case "F":
                result /= 2;
                break;
            case "O":
                result /= 3;
                break;
        }

        System.out.println(result);

	}
}