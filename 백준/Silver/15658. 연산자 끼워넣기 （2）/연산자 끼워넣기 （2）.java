import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static int[] op;
    static int[] result;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static int calculate() {
        int sum = arr[0];
        int idx = 1;

        for(int op : result) {
            int temp = arr[idx++];
            switch(op) {
                case 1:
                    sum += temp;
                    break;
                case 2:
                    sum -= temp;
                    break;
                case 3:
                    sum *= temp;
                    break;
                case 4:
                    if(sum < 0) sum = - (Math.abs(sum) / temp);
                    else sum /= temp;
                    break;
            }
        }
        return sum;
    }

    static void repeatPermutation(int depth) {
        if(depth == N - 1) {
            int sum = calculate();
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for(int i = 1; i <= 4; i++) {
            if(op[i] > 0) {
                result[depth] = i;
                op[i]--;
                repeatPermutation(depth + 1);
                op[i]++;
            }
        }
    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[5];
        result = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        repeatPermutation(0);
        
        System.out.println(max);
        System.out.println(min);
	}

}
