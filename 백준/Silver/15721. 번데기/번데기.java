import java.io.*;
import java.util.*;
// n-1회차 문장일 때는 ‘뻔 – 데기 – 뻔 – 데기 – 뻔(x n번) – 데기(x n번)’
// 1 -> 8번 - 0, 1, 2, 3
// 2 -> 10번 - 8, 9, 10, 11 
// 3 -> 12번 - 18, 19, 20, 21
// 4 -> 14
// 5 -> 16
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int found = Integer.parseInt(br.readLine());

        // 뻔 or 데기의 개수(G의 개수)
        ArrayList<Integer> arr = new ArrayList<>();

        int n = 1;
        int temp = 0;
        int cnt = 8;
        while(cnt <= 40000) {
            arr.add(0);
            arr.add(1);
            arr.add(0);
            arr.add(1);
            for(int j = 0; j <= n; j++) {
                arr.add(0);
            }
            for(int j = 0; j <= n; j++) {
                arr.add(1);
            }
            n++;
            cnt += temp;
            temp += 2;
        }

        cnt = 0;
        int a = 0;
        int i = 0;
        while(true) {
            if(arr.get(i) == found) cnt++;

            if(cnt == T) {
                System.out.println(a);
                break;
            }
            a = a + 1 >= A ? 0 : a + 1;
            i++;
        }
    }
}
