import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
       
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]) return a[0] - b[0];
                else return a[1] - b[1];
            }
        });

        int room = arr[0][1];
        int cnt = 1;
        for(int i = 1; i < N; i++) {
            if(room <= arr[i][0]) {
                room = arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}