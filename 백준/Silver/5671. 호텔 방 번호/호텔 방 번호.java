import java.io.*;
import java.util.*;

public class Main {
    static boolean isNotRepeatedNum(int num) {
        Set<Integer> set = new HashSet<>();
        int len = 0;

        while(num != 0) {
            set.add(num % 10);
            len++;
            num /= 10;
        }
        return set.size() == len;
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;

        StringBuilder sb = new StringBuilder();

        while((s = br.readLine()) != null) {
            int N = Integer.parseInt(s.split(" ")[0]);
            int M = Integer.parseInt(s.split(" ")[1]);

            int sum = 0;
            for(int j = N; j <= M; j++) {
                if(isNotRepeatedNum(j)) sum++;
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
