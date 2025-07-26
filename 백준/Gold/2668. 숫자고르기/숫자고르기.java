import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int N;

    static boolean solution(int i, int cnt, int num) {
        if(cnt >= N) return false;

        if(arr[i] == num) return true;
            
        return solution(arr[i], cnt + 1, num);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= N; i++) {
            if(solution(i, 0, i)) list.add(i);
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int n : list) {
            System.out.println(n);
        }
    }
}