import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) seq[i] = Integer.parseInt(st.nextToken());

		ArrayList<Integer> LIS = new ArrayList<>();
        LIS.add(seq[0]);

		for (int i = 1; i < N; i++) {
			int key = seq[i];

            if (LIS.get(LIS.size() - 1) < key) LIS.add(key);
            else { // 해당 값보다 크면서 가장 가까운 값
				int left = 0;
				int right = LIS.size() - 1;
				while(left < right) {
					int mid = (left + right) / 2;

					if(LIS.get(mid) < key) left = mid + 1;
					else right = mid; 
				}
				LIS.set(left, key);
			}
		}
		System.out.println(LIS.size());
	}
}