import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                set.add(arr[i] + arr[j]);
            }
        }
        
        boolean found = false;
        for(int i = N - 1; i >= 0; i--) {
            for(int j = 0; j < N; j++) {
                if(set.contains(arr[i] - arr[j])) {
                    found = true;
                    break;
                }
            }
            if(found) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
