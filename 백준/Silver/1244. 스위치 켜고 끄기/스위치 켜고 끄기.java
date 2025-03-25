import java.io.*;
import java.util.*;
// 남 -> 스위치 번호가 받은 수의 배수이면 상태를 바꿈
// 여 -> 받은 수를 중심으로 최대 좌우 대칭 구간, 받은 수 찾아서 상태 변경
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[][] s = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s[i][0] = Integer.parseInt(st.nextToken());
            s[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            if(s[i][0] == 1) {
                for(int j = 1; j <= n; j++) {
                    if(j % s[i][1] == 0) {
                        arr[j] = arr[j] == 0 ? 1 : 0;
                    }
                }
            }
            
            if(s[i][0] == 2) {
                int idx = s[i][1];
                arr[idx] = arr[idx] == 0 ? 1 : 0;
                for(int j = 1; j < n / 2; j++) {
                    if(idx - j <= 0 || idx + j > n) break;
                    if(arr[idx - j] == arr[idx + j]) {
                        arr[idx - j] = arr[idx - j] == 0 ? 1 : 0;
                        arr[idx + j] = arr[idx - j];
                    } else break;
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
            if(i % 20 == 0) System.out.println();
        }
    }
}
