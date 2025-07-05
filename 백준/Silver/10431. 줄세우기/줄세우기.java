import java.io.*;
import java.util.*;

public class Main {
	static int numOfSteps(int height, ArrayList<Integer> heights) {
		int idx = heights.size();

		for(int i = 0; i < heights.size(); i++) {
			if(height < heights.get(i)) {
				idx = i;
				break;
			}
		}

		heights.add(idx, height);
		return heights.size() - idx - 1;
	}
    
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i ++) {
			ArrayList<Integer> heights = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tNum = Integer.parseInt(st.nextToken());

			int sum = 0;
			for(int j = 0; j < 20; j ++) {
				int t = Integer.parseInt(st.nextToken());
				sum += numOfSteps(t, heights);
			}
			System.out.println(tNum + " " + sum);
		}	
	}
}