import java.io.*;

public class Main {
	static long binarySearch(long left, long right, long key) {
		while(left <= right) {
			long mid = (left + right) / 2;

			if(key <= Math.pow(mid, 2)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
    
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		System.out.println(binarySearch(0, n, n));
	}
}
