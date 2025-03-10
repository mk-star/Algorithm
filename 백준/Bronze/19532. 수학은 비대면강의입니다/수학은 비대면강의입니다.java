import java.io.*;
import java.util.*;
// ax + by = c
// dx + ey = f

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[6];
        for(int i = 0; i < 6; i++) num[i] = Integer.parseInt(st.nextToken());

        int x = (num[1] * num[5] - num[2] * num[4]) / (num[1] * num[3] - num[0] * num[4]);
        int y = (num[2] * num[3] - num[0] * num[5]) / (num[1] * num[3] - num[0] * num[4]);

        System.out.println(x + " " + y);
    }
}
