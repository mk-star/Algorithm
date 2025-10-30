import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 요청한 그램한 금액을 배정할 수 있으면 하고
        // 2. 할 수 없다면 상한액보다 넘은 경우 해당 금액을 배정. 이하는 요청 금액

        //max값을 구하고

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 1;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        int M = Integer.parseInt(br.readLine());

        long maxSum = 0;
        int result = 0;
        for(int i = 1; i <= max; i++) {
            long sum = 0;
            for(int j = 0; j < N; j++) {
                if(i < arr[j]) sum += i;
                else sum += arr[j];
            }

            // 정해진 총액을 넘은 경우 종료
            if(M < sum) break;

            // sum이 최대이면서 정해진 총액 이하인 경우
            if(maxSum < sum && M >= sum) {
                maxSum = sum;
                result = i;
            }
        }
        System.out.println(result);
    }
}
